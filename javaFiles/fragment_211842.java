package example;

import java.io.*;
import java.nio.charset.*;

public class Test {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                Test.class.getResourceAsStream("/resources/names.txt"),
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}