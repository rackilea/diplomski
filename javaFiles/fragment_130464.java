public static void main(String[] args) {
    int[][] matrix = { {  10,  17, 200, 255,   0 },
                       {   0, 199, 100,  30,  45 },
                       { 250,  23, 177, 180,  79 },
                       {   0,   9,  14, 150,  70 },
                       {  50,  55, 187,  10, 233 } };
    print(matrix);
    duplicateAlternates(matrix);
    print(matrix);
}
private static void print(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++)
            System.out.printf(" %3d", matrix[row][col]);
        System.out.println();
    }
    System.out.println();
}