timeTempText">(.*?)<\/span>


import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "timeTempText\">(.*?)<\\/span>";
final String string = "<span class="timeTempText">6:35a</span><span class="dividerText"> | </span><span class="timeTempText">59Â°F</span>"
     + "asdfasdf asdfasdf timeTempText\">59Â°F</span> asdfasdf\n";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}