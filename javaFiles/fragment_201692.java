static void set(boolean[][] aM, int cols, int row0, int col0, int row1, int col1) {
    int index0 = row0 * cols + col0;
    int index1 = row1 * cols + col1;
    aM[index0][index1] = aM[index1][index0] = true;
}

static boolean[][] adjacencyMatrix(char[][] cA) {
    int rows = cA.length;
    int cols = cA[0].length;
    boolean[][] aM = new boolean[rows * cols][rows * cols];
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            if (cA[i][j] == 'y')
                continue;
            if (i + 1 < rows && cA[i + 1][j] != 'y')
                set(aM, cols, i, j, i + 1, j);
            if (j + 1 < cols && cA[i][j + 1] != 'y')
                set(aM, cols, i, j, i, j + 1);
        }
    }
    return aM;
}

public static void main(String[] args) {
    char[][] cA = {
        {'z', 'y', 'z'},
        {'z', 'z', 'z'},
        {'z', 'y', 'y'},
    };
    boolean[][] aM = adjacencyMatrix(cA);
    for (boolean[] row : aM) {
        for (boolean cell : row)
            System.out.print(cell ? "1" : "0");
        System.out.println();
    }
}