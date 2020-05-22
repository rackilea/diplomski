import java.math.BigDecimal;
import java.util.regex.*;

public class Test {
    public static void main(String args[]) throws Exception {
        Pattern pattern = Pattern.compile("[^(]*\\(([0-9]*\\.[0-9]*)s");        
        String text = "Host is up (0.0020s latency).";

        Matcher match = pattern.matcher(text);
        if (match.lookingAt())
        {
            String group = match.group(1);
            System.out.println("Before parsing: " + group);
            BigDecimal value = new BigDecimal(group);
            System.out.println("Parsed: " + value);
        }
        else
        {
            System.out.println("No match");
        }
    }
}