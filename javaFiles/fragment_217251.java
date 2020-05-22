public class Test {

    static final int S = 9;
    int[][] sudo;

    public Test() {
        // Just leave it empty.
        sudo = new int[S][S];
    }

    public Test(int[][] sudo) {
        this.sudo = sudo;
    }

    // This number should not appear anywhere in the row.
    public boolean checkHorizontal(int row, int num) {
        for (int i = 0; i < S; i++) {
            if (sudo[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    // This number should not appear anywhere in the col.
    public boolean checkVertical(int col, int num) {
        for (int i = 0; i < S; i++) {
            if (sudo[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    // This number should not appear anywhere in the box.
    private boolean checkBox(int row, int col, int num) {
        // Round down to nearest 3.
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudo[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean check(int row, int col, int num) {
        // All checks must pass.
        return checkHorizontal(row, num)
                && checkVertical(col, num)
                && checkBox(row, col, num);
    }

    public boolean solve(int row, int col) {
        // Got to the end?
        if (row >= S) {
            //Gelöst
            return true;
        }
        // If the cell is empty
        if (sudo[row][col] == 0) {
            // Find a valid number for the empty cell
            for (int num = 1; num < 10; num++) {
                // Can this number be put there?
                if (check(row, col, num)) {
                    // Yes!
                    sudo[row][col] = num;
                    // Try that.
                    if (next(row, col)) {
                        return true;
                    }
                }
            }
            // Clean up.
            sudo[row][col] = 0;
        } else {
            // Move on.
            if (next(row, col)) {
                return true;
            }
        }
        // Failed to find a solution.
        return false;
    }

    //Ruft solve für das nächste Feld auf
    public boolean next(int row, int col) {
        if (col < S - 1) {
            // Step right.
            return solve(row, col + 1);
        } else {
            // Step down.
            return solve(row + 1, 0);
        }
    }

    public boolean boardOk() {
        // Initial test to ensure it is a valid array.
        // Must have that many rows.
        boolean ok = sudo.length == S;
        for (int row = 0; ok && row < S; row++) {
            // Each row must be that long.
            ok &= sudo[row].length == S;
            for (int col = 0; ok && col < S; col++) {
                // Each filled square must be valid.
                if (sudo[row][col] != 0) {
                    int num = sudo[row][col];
                    // Remove it.
                    sudo[row][col] = 0;
                    // Check it can be added.
                    ok &= check(row, col, num);
                    // Put it back.
                    sudo[row][col] = num;
                }
            }
        }
        return ok;
    }

    void solve() {

        if (boardOk()) {
            boolean solved = solve(0, 0);
            if (solved) {
                System.out.println("Solved!");
                print();
            }
        } else {
            System.out.println("Insoluble!");
            print();
        }
    }

    public void print() {
        for (int i = 0; i < sudo.length; i++) {
            System.out.println(Arrays.toString(sudo[i]));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Test().solve();
        int[][] test = {
            {0, 0, 6, 5, 8, 3, 3, 2, 7},
            {0, 0, 0, 0, 9, 0, 0, 5, 0},
            {5, 8, 0, 0, 0, 0, 0, 0, 3},
            {0, 3, 1, 0, 4, 0, 5, 0, 0},
            {0, 0, 0, 9, 2, 0, 3, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {3, 4, 2, 0, 0, 6, 9, 1, 5},
            {5, 0, 5, 4, 0, 9, 0, 3, 2},
            {0, 1, 0, 0, 0, 0, 0, 0, 4},};
        new Test(test).solve();
    }
}