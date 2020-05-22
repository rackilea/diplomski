public static int minColIndex (int[][] m) {

    int row = m.length, col = m[0].length; 
    int min = m[0][0]; 
    int minCol = 0; // extra variable to store minimumm column
    for (col = 0; col < m.length; col++) {
        for (row = 0; row < m[col].length; row++) {
            if (min > m[col][row]) {
                min = m[col][row];
                minCol = col; // remember the minimum column as well as minimum
            }
        }
    }
    return minCol; // return minimum column, not col

}