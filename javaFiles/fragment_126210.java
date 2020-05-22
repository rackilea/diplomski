import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyHandler {

    public static void main(String[] args) {
        Pattern p = Pattern.compile(
                "\[url.*\](.*)\[/url\]",
                Pattern.DOTALL
            );

        Matcher matcher = p.matcher(
                "[url=https://play.google.com/store/apps/details?id=xxx]----sent from my Sony Ericsson LT28h,Android 4.2.1[/url]"
            );

        if(matcher.matches()){
            System.out.println(matcher.group(1));
        }
    }
}