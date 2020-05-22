import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com/");
        String file = System.getProperty("java.io.tmpdir") + "google.txt";
        System.out.println("Saving file to " + file);
        try (InputStream in = url.openStream();
            OutputStream os = new FileOutputStream(file)) {
            int b;
            while ((b = in.read()) != -1) {
                os.write(b);
            }
        }
    }
}