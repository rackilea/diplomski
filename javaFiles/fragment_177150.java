public class App {
    public static void main(String[] args) {
        int[] result = sort(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});

        System.out.println("result = " + Arrays.toString(result));
    }

    static int[] sort(int[][] matrix) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i].length;
        }

        // indexes variable store current position for each row.
        int[] indexes = new int[matrix.length];
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            // this loop search for row with minimal current position.
            for (int j = 0; j < matrix.length; j++) {
                //Ignore row which are exhausted
                if (indexes[j] >= matrix[j].length) {
                    continue;
                }
                if (matrix[j][indexes[j]] <= minValue) {
                    minIndex = j;
                    minValue = matrix[j][indexes[j]];
                }
            }
            result[i] = matrix[minIndex][indexes[minIndex]];
            indexes[minIndex]++;
        }

        return result;
    }
}