import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class EmailValidator {

private Pattern pattern;
private Matcher matcher;

private static final String EMAIL_PATTERN = 
    "^(?=.*[0-9]*[a-z]*[A-Z])(?=.*[a-zA-Z])([a-zA-Z0-9]{8,20}+@[A-Za-z0-9]+.(com|org|edu|mil|net))$";

public EmailValidator() {
    pattern = Pattern.compile(EMAIL_PATTERN);
}

/**
 * Validate hex with regular expression
 * 
 * @param hex
 *            hex for validation
 * @return true valid hex, false invalid hex
 */
public boolean validate(final String hex) {

    matcher = pattern.matcher(hex);
    return matcher.matches();

}
   }