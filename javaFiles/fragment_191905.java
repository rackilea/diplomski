import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(final String[] args)
    {
        final String input = args[0];
        final Pattern pattern = Pattern.compile("^.*\\\\(.*)\\.exe.*$");
        final Matcher matcher = pattern.matcher(input);
        if (matcher.find())
        {
            System.out.println("matcher.group(1) = " + matcher.group(1));
        }
        else
        {
            System.out.format("%s does not match %s\n", input, pattern.pattern());
        }
    }
}