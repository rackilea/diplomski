import java.util.regex.Matcher;
 import java.util.regex.Pattern;

public class ValidatorUtil {

private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+ HERE PUT YOUR ADITIONAL CHARACTERS]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

/**
 * Validate given email with regular expression.
 * 
 * @param email
 *            email for validation
 * @return true valid email, otherwise false
 */
public static void main(String args[])
{


    String email = "aáaaa@gmail.com";
    // Compiles the given regular expression into a pattern.
    Pattern pattern = Pattern.compile(PATTERN_EMAIL);

    // Match the given input against this pattern
    Matcher matcher = pattern.matcher(email);
    System.out.println(matcher.matches());


}

}