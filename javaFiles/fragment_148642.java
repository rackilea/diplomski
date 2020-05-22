import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "\\$(\\d+)|(\\b[A-Z]\\S+\\b)";
final String string = "buy a $30 giftcard for John\n"
     + "buy John a $30 giftcard";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}