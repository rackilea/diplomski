import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFlags {
    public static void main(String[] args) {
        String s = "foo\nbar";
        System.out.println(s.matches("foo.bar"));
        System.out.println(s.matches("(?s)foo.bar"));
        Matcher m = Pattern.compile("foo.bar", Pattern.DOTALL).matcher(s);
        System.out.println(m.matches());
    }
}