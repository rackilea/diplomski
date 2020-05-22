import java.io.*;

public class CopyInput {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in, Charset.defaultCharset()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        }
    }
}