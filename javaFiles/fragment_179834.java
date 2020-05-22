package sub.optimal.mvnproperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        String fileName = "application.properties";
        ClassLoader classLoader = Main.class.getClassLoader();
        try (InputStream in = classLoader.getResourceAsStream(fileName)) {
            // add check if the stream is open
            Properties prop = new Properties();
            prop.load(in);
            prop.entrySet().stream().forEach((entry) -> {
                System.out.printf("%s:%s%n", entry.getKey(), entry.getValue());
            });
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}