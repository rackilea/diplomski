import java.util.*;
import java.util.regex.*;

public class Test
{
    public static void main(String[] args)
        throws PatternSyntaxException
    {
        // Want to get x10 and x5 from this
        String text = "x10 y5 x5 xyz";
        String pattern = "x\\d+";
        List<String> matches = getAllMatches(text, pattern);
        for (String match : matches) {
            System.out.println(match);
        }
    }

    public static List<String> getAllMatches(String text, String pattern)
        throws PatternSyntaxException
    {
        Pattern regex = Pattern.compile(pattern);
        List<String> results = new ArrayList<String>();
        Matcher regexMatcher = regex.matcher(text);
        while (regexMatcher.find()) {
            results.add(regexMatcher.group());
        }
        return results;
    }
}