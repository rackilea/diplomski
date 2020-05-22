import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {


    private static void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getResourceAsStream("/config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}