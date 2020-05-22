public static final int SIZE = 9;

public static boolean solve(int[][] s) {

    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (s[i][j] != 0) {
                continue;
            }
            for (int num = 1; num <= SIZE; num++) {
                if (isValid(num, i, j, s)) {
                    s[i][j] = num;
                    if (solve(s)) {
                        return true;
                    } else {
                        s[i][j] = 0;
                    }
                }
            }
            return false;
        }
    }
    return true;
}