import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFlags {
    public static void main(String[] args) {
        String in =
            "<td class=\"foobar\" id=\"12345POE46\" data=\"more &amp; data\">\n" +
            "    <a href=\"http://www.stackoverflow.com\" more=\"{data}\">Value</a>\n" +
            "</td>";
        Matcher matcher = Pattern
                .compile("(?s)<td class=\"foobar\".*?<a.*?>(.*?)</a>.*?</td>")
                .matcher(in);
        System.out.println(matcher.find());
        System.out.println(matcher.group(1));
    }
}