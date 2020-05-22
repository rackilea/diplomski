public static void floodFill(int row, int col) {
    if (newGrid[row][col].equals('-')) {
        newGrid[row][col] = ' ';
        floodFill(row - 1, col - 1);
        floodFill(row - 1, col);
        floodFill(row - 1, col + 1);
        floodFill(row, col - 1);
        floodFill(row, col + 1);
        floodFill(row + 1, col - 1);
        floodFill(row + 1, col);
        floodFill(row + 1, col + 1);
    }
}