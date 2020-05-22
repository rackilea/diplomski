import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<String> input = Arrays.asList("jonas", "ton", "bonny");

        System.out.println(findCommonCharsFor(input));
    }

    public static Collection<Character> findCommonCharsFor(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return Collections.emptyList();
        }

        Set<Character> commonChars = convertStringToSetOfChars(strings.get(0));
        strings.stream().skip(1).forEach(s -> commonChars.retainAll(convertStringToSetOfChars(s)));

        return commonChars;
    }

    private static Set<Character> convertStringToSetOfChars(String string) {
        if (string == null || string.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Character> set = new HashSet<>(string.length() + 10);
        for (char c : string.toCharArray()) {
            set.add(c);
        }

        return set;
    }
}