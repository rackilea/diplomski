import java.util.*;
import java.util.regex.Pattern;

public class X {

    public static void main(String[] args) {
        wordpattern("abba", "bluegreengreenblue");
    }

    protected static boolean wordpattern(String pattern, String input) {
        Map<Character,Integer> patternItemNumbers = new HashMap<>();
        StringBuilder regularExpression = new StringBuilder();
        int groupCount = 1;

        for (char patternItem : pattern.toCharArray()) {
            Integer group = patternItemNumbers.get(patternItem);

            // first occurrence: create new fetching group
            if (group == null) {
                regularExpression.append("(.+)");
                patternItemNumbers.put(patternItem, groupCount++);
            }

            // every next occurrence: reuse group by identifier
            else {
                regularExpression.append('\\');
                regularExpression.append(group);
            }
        }

        String regexp = regularExpression.toString();
        boolean matches = Pattern.matches(regexp, input);

        System.out.println("pattern: "+pattern);
        System.out.println("regular expression: "+regexp);
        System.out.println("matches: "+matches);

        return matches;
    }

}