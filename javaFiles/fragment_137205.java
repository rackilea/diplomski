import java.io.File;
import java.util.regex.Matcher;

class Test {
    public static void main(String[] args) {
        String s = "a/b/c/d";
        String sep = "\\"; // File.separator;
        s = s.replaceAll("/", Matcher.quoteReplacement(sep));
        System.out.println(s);
    }
}