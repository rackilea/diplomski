import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TmpTest {
    public static void main(String args[]) {
        final String regex = "\".*?\"|\\b\\w+\\b";
        final String string = "\"word to\" split i should get \"word to2\", split.";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
        }
    }
}