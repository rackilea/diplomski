public static boolean findValTest(int[][] m, int val) {
    for (int row = 0; row < m.length; row++) {
        if (m[row][0] <= val && row != m.length - 1)
            continue;

        int r = row;

        while (r >= row - 1 && r >= 0) {
            for (int col = 0; col < m[r].length; col++)
                if (m[r][col] == val)
                    return true;

            r--;
        }

        return false;
    }

    return false;
}