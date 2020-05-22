import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {
 private static final String AND = " and ";
 private static final String COMMA = ", ";

 // your initial call wrapped with a replaceLast call
 public static String asLiteralNumeration(List<String> strings) {
    return replaceLast(strings.stream().collect(Collectors.joining(COMMA)), COMMA, AND);
 }

 public static String replaceLast(String text, String regex, String replacement) {
    return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
 }
}