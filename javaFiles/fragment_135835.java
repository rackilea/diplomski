import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {

    public static void main( String[] args ) {
        String mydata ="Test Test <test@test.com>";
        Pattern pattern = Pattern.compile(".*<(.*)>");
        Matcher matcher = pattern.matcher(mydata);

        String email = null;
        if (matcher.find())
        {
            email = matcher.group(1);

        }
         System.out.println(email);
    }
}