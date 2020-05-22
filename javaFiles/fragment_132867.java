public static void printBoard(int[][] array, int x, int y) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if (i == x && j == y) {
                System.out.printf("|%2d|\t", array[i][j]);
            } else {
                System.out.printf(" %2d \t", array[i][j]);
            }
        }
        System.out.println();
    }
}