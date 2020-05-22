import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String text1 = "This is an example.";
        String text2 = "This is another example, but this time the sentence is longer";
        String key = "example";
        String regex = "((\\w+\\s){2})?" + key +"([,](\\s\\w+){0,2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text1);
        matcher.find();
        System.out.println(matcher.group(0));
        matcher = pattern.matcher(text2);
        matcher.find();
        System.out.println(matcher.group(0));
    }
}