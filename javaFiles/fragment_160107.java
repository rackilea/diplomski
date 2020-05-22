static boolean has(int number, int[][] a) {
    int row = 0;
    int col = a[0].length - 1;
    while (row < a.length && col >= 0) {
        int n = a[row][col];
        if (n < number) {
            row++;
        } else if (n > number) {
            col--;
        } else {
            return true;
        }
    }
    return false;
}