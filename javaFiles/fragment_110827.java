public class MatrixTranspose {
        static int m1[][] = new int[][]{{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}, {9, 10, 11, 12, 13}, {13, 14, 15, 16, 17}};
        public static String toString(int[][] m) {
            StringBuilder text = new StringBuilder();
            for (int row = 0; row < m.length; row++) {
                int r[] = m[row];
                for (int col = 0; col < r.length; col++) {
                    if (col > 0) text.append(", ");
                    text.append(r[col]);
                }
                text.append("\n");
            }
            return text.toString();
        }

        public static int[][] transpose(int[][] m) {
            int rows = m.length;
            int cols = m[0].length;

            int t[][] = new int[cols][]; // first create the empty transpose matrix
            for (int trow = 0; trow < cols; trow++) {
                t[trow] = new int[rows];
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int tcol = rows-row-1; // transposed tcol is inverted row
                    int trow = cols-col-1; // transposed trow is inverted col
                    t[trow][tcol] = m[row][col];
                }
            }
            return t;
        }

        public static void main(String...params) {
            System.out.println(toString(m1));
            System.out.println("--");
            System.out.println(toString(transpose(m1)));
        }
    }