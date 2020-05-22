public class PascalTriangle {
    public static void main(String[] args) {
        printPascal(5);
    }

    private static void printPascal(int i) {
        auxPrintPascal(0, i);
    }

    private static void auxPrintPascal(int row, int numOfRows) {
        if (row > numOfRows) {
            return;
        }
        printPascalTriangleRow(row, 0);
        System.out.println();
        auxPrintPascal(row + 1, numOfRows);
    }

    private static void printPascalTriangleRow(int row, int col) {
        if (col > row) {
            return;
        }
        System.out.print(binomial(row, col) + " ");
        printPascalTriangleRow(row, col + 1);
    }

    private static long binomial(int n, int k) {
        if (k > n - k)
            k = n - k;

        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b * m / i;
        return b;
    }
}