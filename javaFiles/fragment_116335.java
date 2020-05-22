private static void sillyPrintPascal(int row, int col, int numOFRows) {
        if (row > numOFRows) {
            return;
        }
        if (col > row) {
            return;
        }
        System.out.print(binomial(row, col) + " ");
        if (col == row) {
            System.out.println();
            sillyPrintPascal(row + 1, 0, numOFRows);
        } else {
            sillyPrintPascal(row, col + 1, numOFRows);
        }
    }