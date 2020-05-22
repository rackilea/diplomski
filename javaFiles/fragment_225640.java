public static int[][] Zig_Zag(int size) {
    int[][] a = new int[size][size];
    int n = 1;
    for (int r = size, c = 0; r >= 0; --r)
        for (int i = r, j = c; i < size; ++i, ++j)
            a[i][j] = n++;
    for (int r = 0, c = 1; c < size; ++c)
        for (int i = r, j = c; j < size; ++i, ++j)
            a[i][j] = n++;
    return a;
}