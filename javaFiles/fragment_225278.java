import java.util.Arrays;

    class Scratch {
        public static void main(String[] args) {

            int[][] arr = new int[21][21];
            int row = 20;
            int column = 0;

            for (int i = 0; i < 21; i ++) {

                column = row;

                for (int j = 0; j < 21; j++) {
                    arr[i][j] = column;

                    if (j < 10) {
                        column = column - 1;
                    } else {
                        column = column + 1;
                    }
                }

                if (i < 10) {
                    row = row - 1;
                } else {
                    row = row + 1;
                }
            }

            for (int[] arrRow : arr) {
                System.out.println(Arrays.toString(arrRow));
            }
        }
    }