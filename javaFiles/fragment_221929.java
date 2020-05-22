import java.util.Arrays;
import java.util.List;

public class NameGenerator {

    final static List<String> syllables = Arrays.asList("ka", "sa", "ta", "na", "ha", "ma", "ya", "ra", "wa",
            "ki", "si", "ti", "ni", "hi", "mi", "yi", "ri", "wi",
            "ku", "su", "tu", "nu", "hu", "mu", "yu", "ru", "wu",
            "ke", "se", "te", "ne", "he", "me", "ye", "re", "we",
            "ko", "so", "to", "no", "ho", "mo", "yo", "ro", "wo");
    final static int maxSyllable = syllables.size() - 1;

    public static void main(String[] args) {
        int[] attributes = new int[]{25, 325, 4, 2, 11, 98, 23};
        String name = toName(attributes);
        System.out.println("name = " + name);
    }

    public static String toName(int[] attributes) {
        int hashCode = Arrays.hashCode(attributes);
        int smallHashCode = (hashCode >> 16) ^ (hashCode & 0xffff);
        return toName(smallHashCode);
    }

    public static String toName(int i) {
        if (i < 0) {
            i = -i;
        }
        StringBuilder buf = new StringBuilder();
        while (i > maxSyllable) {
            buf.append(syllables.get(i % maxSyllable));
            i = i / maxSyllable;
        }
        buf.append(syllables.get(i));
        return buf.toString();
    }
}