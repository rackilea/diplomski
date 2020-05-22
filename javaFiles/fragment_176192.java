import java.util.ArrayList;
import java.util.List;

public class CombinationSplit {

    public static void main(String[] args) {

        List<String> split = split("a\\b\\c\\d", "\\\\");
        for (String s : split) {
            System.out.println(s);
        }
    }


    private static List<String> split(String s, String delimiter) {
        String[] split = s.split(delimiter);
        List<String> output = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            int[][] combinations = consecutiveCombinations(split.length, i);
            for (int[] combination : combinations) {
                 output.add(glue(split, combination, delimiter));
            }
        }
        return output;
    }


    private static String glue(String[] string, int[] indices, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, indicesLength = indices.length; i < indicesLength - 1; i++) {
            int index = indices[i];
            stringBuilder.append(string[index]);
            stringBuilder.append(delimiter);
        }
        stringBuilder.append(string[indices[indices.length - 1]]);
        return stringBuilder.toString();
    }

    private static int[][] consecutiveCombinations(int n, int k) {
        int count = n - k + 1;
        int[][] output = new int[count][k];
        for (int i = 0; i < count; i++) {
            int[] path = new int[k];
            for (int j = 0; j < k; j++) {
                path[j] = i + j;
            }
            output[i] = path;
        }
        return output;
    }

}