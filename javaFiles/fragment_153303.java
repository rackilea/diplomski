import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String[] args) {
      String input = "/[ANY]/Java/Groovy*/Test";
      Pattern pattern = Pattern.compile("Groovy(.*?)$");
      Matcher matcher = pattern.matcher(input);
      System.out.println(matcher.find());
    }
}