import java.util.*;

public class Phonkw {
    private static final Map<String, String> consonantReplace = createConsonantReplaceMap();

    private static Map<String, String> createConsonantReplaceMap() {
        final Map<String, String> map = new HashMap<>();
        final String consonants = "BCDFGHJKLMNPQRSTVWXZ";
        for (final char consonant : consonants.toCharArray())
            map.put(consonant + "W", consonant + "OU");
        return Collections.unmodifiableMap(map);
    }

    public static String phonkw1(final String tampon) {
        if (tampon == null) return "";
        if (tampon.length() < 2) return tampon;
        final String key = tampon.substring(0, 2);
        if (consonantReplace.containsKey(key))
            return consonantReplace.get(key) + tampon.substring(2);
        return tampon;
    }

    public static void main(final String... args) {
        for (final String arg : args)
            System.out.println(phonkw1(arg));
    }
}