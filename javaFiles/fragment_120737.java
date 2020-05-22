import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("[.!?]");
        Matcher m = pattern.matcher("Hello?World!...");
        while (m.find()) {
            System.err.println(m.group());
        }
    }

}