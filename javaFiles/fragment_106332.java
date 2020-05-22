for (int r = 0; r < matrix.length; r++) {
    for (int c = 0; c < matrix[0].length; c++) {
    System.out.print(" " + (matrix[r][c] ? "y" : "x"));
    }
    System.out.println("");
}