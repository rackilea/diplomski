import java.util.*;

public class LCS {
    static void getLongestCommonSubsequence(String[] a, String[] b, List<String> output) {
        if (a.length == 0 || b.length == 0) {
        } else if (a[0].equals(b[0])) {
            output.add(a[0]);
            getLongestCommonSubsequence(Arrays.copyOfRange(a, 1, a.length), Arrays.copyOfRange(b, 1, b.length), output);
        } else {
            List<String> discardA = new ArrayList<String>();
            getLongestCommonSubsequence(Arrays.copyOfRange(a, 1, a.length), b, discardA);
            List<String> discardB = new ArrayList<String>();
            getLongestCommonSubsequence(a, Arrays.copyOfRange(b, 1, b.length), discardB);
            if (discardA.size() >= discardB.size()) {
                output.addAll(discardA);
            } else {
                output.addAll(discardB);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"The", "great", "square", "has", "a", "same", "no", "corners"};
        String[] b = {"The", "great", "image", "has", "no", "a", "same", "form"};
        List<String> output = new ArrayList<String>();
        getLongestCommonSubsequence(a, b, output);
        System.out.println(output);
    }
}