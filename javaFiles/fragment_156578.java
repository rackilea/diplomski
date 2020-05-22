import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternExample {
    private static final Pattern JS_PATTERN = Pattern.compile("javascript:[rl]\\(\\d+\\)");
    private static final String[] MESSAGES = {
        "Good javascript:r(5)",
        "Good javascript:l(50003843)",
        "Good javascript:r(1123934)",
        "Bad javascript:|(5)",
        "Bad javascript:r(53d)",
        "Bad javascript:l()",
    };
    public static void main(String[] args) {
        for (String s : MESSAGES) {
            Matcher matcher = JS_PATTERN.matcher(s);
            System.out.println(matcher.replaceAll(""));
        }
    }
}