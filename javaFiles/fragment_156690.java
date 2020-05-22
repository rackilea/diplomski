import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SimpleRegexTester {
    public static void main(String[] args) {
        String repeatedFooBar = String.join("", Collections.nCopies(666, "foobar"));
        Pattern p = Pattern.compile("(foo|bar)*");
        Matcher m = p.matcher(repeatedFooBar);

        if (m.matches())
            System.out.println("Done matching");
    }
}