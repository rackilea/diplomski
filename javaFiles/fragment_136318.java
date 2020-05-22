import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args){
        Pattern p = Pattern.compile("house_(\\d+)\\.png");
        Matcher m = p.matcher("house_234.png");

        if (m.find()) {
            System.out.println(m.group(1)); //print the number
        }
    }
}