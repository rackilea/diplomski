private static boolean recur(int[][] m, int[] rowcount, int[] colcount, 
        int row, int col) {
    if (compare(m, rowcount, colcount)) {
        // our matrix matches the condition
        return true;
    }
    if (row >= m.length) {
        return false;
    }

    int nextcol = col + 1;
    int nextrow = row;
    if (nextcol >= m[row].length) {
        nextcol = 0;
        nextrow++;
        if (nextrow > m.length) {
            return false;
        }
    }
    // OK, so nextrow and nextcol are the following position, and are valid.
    // let's set our current position, and tell the next level of recursion to
    // start playing from the next spot along
    m[row][col] = 1;
    if (recur(m, rowcount, colcount, nextrow, nextcol)) {
        return true;
    }
    // now unset it again
    m[row][col] = 0;
    if (recur(m, rowcount, colcount, nextrow, nextcol)) {
        return true;
    }
    return false;

}