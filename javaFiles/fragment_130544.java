import java.util.*;

public class Translator {

    private static final Map<Character, String> translations = new HashMap<>();
    static {
        translations.put('a', "o9Q5QD8gT8");
        translations.put('A', "x5h10vc4jd15");
        translations.put('1', "S7J11IH4yK16");
    }

    public static void main(final String[] args) {
        System.out.println(translate("abcABC123"));
    }

    private static String translate(final String input) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : input.toCharArray()) {
            sb.append(translate(c));
        }
        return sb.toString();
    }

    private static String translate(final char c) {
        String translation = translations.get(c);
        if (translation == null) {
            translation = Character.toString(c);
        }
        return translation;
    }
}