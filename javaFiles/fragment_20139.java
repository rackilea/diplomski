import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "\\b(https?)(://)(?:w{3}\\.)?([^\\s/:]+)(:\\d{2,6})?/([^?/\\s]+)(\\?)?(\\w+)?#?(\\w+)?\\b";
        final String string = "https://domain:80/path or I could get https://domain/path?query#fragment https://www.domain:80/path or I could get http://domain/path?query#fragment ";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}