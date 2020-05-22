import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "[a-z0-9]*\\d[a-z0-9]*";
final String string = "78784\n"
     + "aZ837\n"
     + "987Ny\n"
     + "19hd35\n"
     + "fc82pl";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}