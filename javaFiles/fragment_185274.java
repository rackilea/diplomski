import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String test1 = "fbrtfuifigfbrt";
        String test2 = "abcdabcd";
        String test3 = "fbrtxibrjkfbrt";
        System.out.println(findRepetitions(test1));
        System.out.println(findRepetitions(test2));
        System.out.println(findRepetitions(test3));
    }

    private static List<String> findRepetitions(String string) {
        List<String> patternsList = new ArrayList<>();
        int length = string.length();
        for (int i = 0; i < length; i++) { // search the first half
            int limit = (length - i) / 2; // candidates can't be longer than half the remaining length
            for (int j = 1; j <= limit; j++) {
                int candidateEndIndex = i + j;
                String candidate = string.substring(i, candidateEndIndex);
                if (string.substring(candidateEndIndex).contains(candidate)) {
                    patternsList.add(candidate);
                }
            }
        }
        return patternsList;
    }
}