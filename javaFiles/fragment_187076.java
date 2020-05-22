import java.io.*;
import java.net.*;

public class Test {
    public void test() throws IOException, URISyntaxException {
        URL url = getClass().getResource("/resources/test.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            for (String line; (line = br.readLine()) != null;) {
                System.out.println("> " + line);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.test();
    }
}