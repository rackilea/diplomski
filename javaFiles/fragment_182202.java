import java.util.regex.Matcher;
import java.util.regex.Pattern;

public void check(String str) {
    Matcher m = Pattern.compile("\\d+").matcher(str);
    for(int n = 0; n < 2 && m.find(); n++)  {
        System.out.println(m.group());
    }
}