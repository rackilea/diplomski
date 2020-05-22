import java.util.Arrays;

public class PermutationCalculator {
    public static void main(String[] args) {
        final int[] input = {1, 3, 3, 4};
        int[][] result = new PermutationCalculator().permutation(input);

        // print result
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public int[][] permutation(int[] input) {
        int[][] result = new int[input.length][]; // i-th row
        for (int i = input.length - 1; i >= 0; i--) {

            // negI starts from 0 instead of i which start from end
            int negI = input.length - i - 1;
            result[negI] = new int[input.length - 1];

            // j is row input array index, 
            // jj is column index (column length = input array -length - 1)
            for (int j = 0, jj = 0; jj < input.length; j++, jj++)
                if (jj == i) {
                    j--;  // don't need increasing in this case 
                } else {
                    result[negI][j] = input[jj];
                }
        }

        return result;
    }
}