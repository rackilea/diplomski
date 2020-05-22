public class MainClass {

    final static int[][] I = {
        {1, 1, 5, 6, 8},
        {2, 3, 5, 7, 1},
        {4, 5, 7, 1, 2},
        {8, 5, 1, 2, 5}
    };

    public static int getMaxValue(int[][] array) {
        int maxValue = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }
            }
        }
        return maxValue;
    }

    static int maxValue = getMaxValue(I);

    public static void main(String[] args) {

        System.out.println("I");
        for (int row = 0; row < I.length; row++) {
            for (int col = 0; col < I[row].length; col++) {
                System.out.print(I[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("maxValue = " + maxValue);

        int[][] GLCM = new int[maxValue + 1][maxValue + 1];

        for (int row = 0; row < I.length; row++) {
            for (int col = 0; col < I[row].length - 1; col++) {
                int x = I[row][col];
                int y = I[row][col + 1];
                GLCM[x][y]++;
            }
        }

        System.out.println("GLCM");
        for (int x = 1; x <= maxValue; x++) {
            for (int y = 1; y <= maxValue; y++) {
                System.out.print(GLCM[x][y] + " ");
            }
            System.out.println();
        }
    }
}