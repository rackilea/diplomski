import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "(\\d{1,2})(:\\d{1,2})?(\\s+)?-(\\s+)?(\\d{1,2})(:\\d{1,2})?(am|pm)";
final String string = "bla bla 1:30-2pm bla bla 5-6:30am some text 1-2:15am\n"
     + "bla bla 1:30 - 2pm bla bla 5  - 6:30am some text 1 - 2:15am";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}