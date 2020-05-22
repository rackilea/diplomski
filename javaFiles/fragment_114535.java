import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = ".{1,10}[^\\s](?=\\s|$)";
final String string = "James has gone out for a meal.";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}