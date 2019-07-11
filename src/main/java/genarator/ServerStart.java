package genarator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ServerStart {

    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        final boolean overwrite = true;
        /* File configFile = new File("genarator.xml"); */
        File configFile = new File(this.getClass().getResource("/genarator.xml").getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {
        try {
            new ServerStart().generator();
            System.out.println("逆向成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
