import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "[*]+\\s+Explorer\\R(.*)";
final String input = "*** Explorer\nGenV Deno Znet";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println("match: " + matcher.group(1));
}