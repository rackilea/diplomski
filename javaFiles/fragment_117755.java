import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        System.out.println("EchoServer started");
        while((input = reader.readLine()) != null) {
            System.out.println("Input: " + input);

            if("exit".equalsIgnoreCase(input)) {
                System.exit(0);
            }
        }
    }
}