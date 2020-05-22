package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Michael
 * @link https://stackoverflow.com/questions/41006856/how-do-i-catch-a-nosuchelementexception?noredirect=1#comment69222264_41006856
 */
public class StringUtils {

    private StringUtils() {}

    public static List<String> tokenize(String str) {
        String [] tokens = new String[0];
        if (isNotBlankOrNull(str)) {
            str = str.trim();
            tokens = str.split("\\s+");
        }
        return Arrays.asList(tokens);
    }

    public static boolean isBlankOrNull(String s) {
        return ((s == null) || (s.trim().length() == 0));
    }

    public static boolean isNotBlankOrNull(String s) {
        return !isBlankOrNull(s);
    }

    public static boolean hasSufficientTokens(int numTokens, String str) {
        return (numTokens >= 0) && tokenize(str).size() >= numTokens;
    }

    public static Map<String, Long> getCharFrequencies(String text) {
        Map<String, Long> charFrequencies = new TreeMap<>();
        if (isNotBlankOrNull(text)) {
            // https://stackoverflow.com/questions/4363665/hashmap-implementation-to-count-the-occurences-of-each-character
            charFrequencies = Arrays.stream(text.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        }
        return charFrequencies;
    }
}