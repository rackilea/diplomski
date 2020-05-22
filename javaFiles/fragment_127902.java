import java.io.*;
import java.util.*;
public class Test {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("test.properties")) {
            properties.load(input);
        }

        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + " = '" + properties.get(key) + "'");
        }
    }
}