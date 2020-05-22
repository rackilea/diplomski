package demo.maven.environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties {

    public String getProperty(String key) throws IOException {
        Properties props = new Properties();
        try (InputStream is = EnvironmentProperties.class.getResourceAsStream("/environment.properties")) {
            props.load(is);
        }
        return props.getProperty(key);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new EnvironmentProperties().getProperty("env.name"));
    }

}