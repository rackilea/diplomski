import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test {

    private static final String REGEX = "\\d+";
    private static final String INPUT = "dog dog 1342 dog doggie 2321 dogg";

    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       Matcher m = p.matcher(INPUT); // get a matcher object
       while(m.find()) {
           System.out.println("start(): "+m.start());
           System.out.println("end(): "+m.end());
       }
    }
}