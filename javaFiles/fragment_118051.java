import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "abc";
        List<String> results = Pattern.compile("\\P{M}\\p{M}*+").matcher(s)
            .results()
            .map(MatchResult::group)
            .collect(Collectors.toList());
        System.out.println(results); 
    }
}
// => [, , a, b, c, ]