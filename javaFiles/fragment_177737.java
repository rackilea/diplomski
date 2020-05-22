import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String tag = "thetag";
        String id = "foo";

        String content = "<tag1>\n"+
                "<thetag name=\"Tag Name\" id=\"foo\">Some text</thetag>\n" +
                "<thetag name=\"AnotherTag\" id=\"foo\">Some more text</thetag>\n" +
                "</tag1>";

        String patternString = "<" + tag + ".*?name=\"(.*?)\".*?id=\"" + id + "\".*?>";

        System.out.println("Content:\n" + content);
        System.out.println("Pattern: " + patternString);

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(content);

        boolean found = false;
        while (matcher.find()) {
            System.out.format("I found the text \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(), matcher.start(), matcher.end());
            System.out.println("Name: " + matcher.group(1));
            found = true;
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }
}