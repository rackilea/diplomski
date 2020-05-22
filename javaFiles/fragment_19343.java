public class TwoDArrays {
    public static void main(String[] args) {
        FillUpTwoDArrays(7, 7);
    }

    public static void FillUpTwoDArrays(int rows, int columns) {
        int twoD[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoD[i][j] = 0;

                for (int k = j; k < twoD[i].length - i; k++) {
                    if (k > i) {
                        twoD[i][k] = 1;
                    }
                }

                if (i == j) {
                    twoD[i][j] = 1;
                }

                if (i + j == rows - 1) {
                    twoD[i][j] = 1;
                }

                for (int h = j; h < twoD[i].length; h++) {
                    if (h < i && j > (rows - i - 1)) {
                        twoD[i][h] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println();
        }
    }
}