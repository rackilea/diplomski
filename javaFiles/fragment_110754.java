import java.io.BufferedReader;
import java.io.FileReader;

public class PFPInterpreter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("print ")) {
                System.out.println(line.substring("print ".length()));
            } else if (line.startsWith("sleep ")) {
                Thread.sleep(Long.parseLong(line.substring("sleep ".length())));
            } else {
                throw new IllegalArgumentException("Unknown function: " + line);
            }
        }
    }
}