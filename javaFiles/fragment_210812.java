import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

public class ConfigOverrideFromCode {
    static public void main(String[] args) {
        String config = "system.administrator = ${who-knows}";

        Config original = ConfigFactory
                    .parseString(config)
                    .resolveWith(ConfigFactory.parseString("who-knows = jon"));
        System.out.println(original.getString("system.administrator"));
    }
}