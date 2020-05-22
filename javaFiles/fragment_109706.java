public static boolean check(int[][]a, int[][]b, int[][]t) {
    int[][] r = add(a, b);
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (r[i][j] != t[i][j]) {
                return false;
            }
        }
    }

    return true;
}