import java.util.regex.*;

public class Test
{
    private static final Pattern EMAIL_PATTERN = Pattern.compile
        ("Email:(.*?\\.edu)");

    public static void main(String[] args)
    {
        String testString = "FooEmail:jjj@xyz.edu Bar Email:mmm@abc.edu Baz";

        printEmails(testString);
    }

    public static void printEmails(String input)
    {
        Matcher matcher = EMAIL_PATTERN.matcher(input);
        while (matcher.find())
        {
            System.out.println(matcher.group(1));
        }
    }
}