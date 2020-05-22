public static void printBox(int rows, int columns) {

    int sumOfColumns = 2 * columns + rows - 1;
    int sumOfRow = 2 * columns + 2 * rows - 2;

    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= columns; j++) {
            if (i == 1) {
                System.out.printf(String.format("%3d", j));
            } else if (j == 1) {
                System.out.printf(String.format("%3d", sumOfRow - (i + j - 1)));
            } else if (j == columns) {
                System.out.printf(String.format("%3d", i + j - 1));
            } else if (i == rows) {
                System.out.printf(String.format("%3d", sumOfColumns - j));
            } else {
                System.out.print("   ");
            }
        }
        System.out.print("\n");
    }
    System.out.print("\n");
}