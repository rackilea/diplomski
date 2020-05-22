public static String loop(double[][] twoDArray) {

    int columns = twoDArray.length;
    int rows = twoDArray[0].length;

    double[][] differences = new double[columns][rows];

    for (int i = 0; i < columns; i++) {
        for (int j = 0; j < rows; j++) {
            // Absolute difference between the value of this column compared to the previous
            // -1 if this is the first column
            // Prints: [[-1.0, -1.0, -1.0], [3.0, 3.0, 3.0], [3.0, 3.0, 3.0], [3.0, 3.0, 3.0]]
            if (i == 0) {
                differences[i][j] = -1;
            } else {
                differences[i][j] = Math.abs(twoDArray[i][j] - twoDArray[i - 1][j]);
            }
        }
    }

    return Arrays.deepToString(differences);
}

public static void main(String[] args) {
    double[][] twoArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}; // Note that I removed a comma.
    System.out.println(loop(twoArray));
}