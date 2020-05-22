import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String s = new String("\"Hello\" hello");
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}