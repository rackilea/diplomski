public static void printSquare(int[][] square) {
    for (int row = 0; row < square.length; row++) {
        for (int col = 0; col < square.length; col++) {
            System.out.print(square[row][col]+"\t");
        }
        System.out.println();
    }
}