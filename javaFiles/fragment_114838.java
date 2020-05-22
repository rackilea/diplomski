private static final int ZERO = 1;
private static final int OFFS = 3;

public static int get(int row, int col) {
    int val = ZERO;

    for (int i = 0; i < row; i++)
        val += OFFS;

    for (int i = 0; i < col; i++)
        val += OFFS;

    return val;
}