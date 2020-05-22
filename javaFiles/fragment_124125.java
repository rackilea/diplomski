import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){


        final String regex = "^(?:[0-9]{1,12}(?:\\.[0-9]{0,4})?|\\.[0-9]{0,4})$";
        final String string = "123456789012.1234\n"
             + "123456789012\n"
             + ".1235\n"
             + ".123\n"
             + "123.\n"
             + ".12345\n"
             + "0.12345";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }


    }
}