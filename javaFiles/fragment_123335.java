import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static String[][] skipBigrams(String input) {
        String[] tokens = input.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        return skipBigrams(tokens);
    }

    private static String[][] skipBigrams(String[] tokens) {
        List<String[]> bigrams = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            for (int j = i + 1; j < tokens.length; j++) {
                bigrams.add(new String[]{tokens[i], tokens[j]});
            }
        }
        String[][] result = new String[bigrams.size()][2];
        result = bigrams.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        String s1 = "I love green apples.";
        System.out.println(Arrays.deepToString(skipBigrams(s1)));
    }
}