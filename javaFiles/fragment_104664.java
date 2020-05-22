// returns 0, 1 or more than 1 depending on whether 0, 1 or more than 1 solutions are found
static byte solve(int i, int j, int[][] cells, byte count /*initailly called with 0*/) {
    if (i == 9) {
        i = 0;
        if (++j == 9)
            return 1+count;
    }
    if (cells[i][j] != 0)  // skip filled cells
        return solve(i+1,j,cells, count);
    // search for 2 solutions instead of 1
    // break, if 2 solutions are found
    for (int val = 1; val <= 9 && count < 2; ++val) {
        if (legal(i,j,val,cells)) {
            cells[i][j] = val;
            // add additional solutions
            count = solve(i+1,j,cells, count));
        }
    }
    cells[i][j] = 0; // reset on backtrack
    return count;
}