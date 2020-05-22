static int count_neighbors(int i, int j) {
    int nn = 0; // number of neighbors of cell(i,j)

    if (i > 0 && j > 0 && grid[i - 1][j - 1] == 'X') {
        nn++;
    }
    ;
    if (i > 0 && grid[i - 1][j] == 'X') {
        nn++;
    }
    ;
    if (i > 0 && j < 72 && grid[i - 1][j + 1] == 'X') {
        nn++;
    }
    ;
    if (j > 0 && grid[i][j - 1] == 'X') {
        nn++;
    }
    ;
    if (j < 72 && grid[i][j + 1] == 'X') {
        nn++;
    }
    ;
    if (j > 0 && i < 22 && grid[i + 1][j - 1] == 'X') {
        nn++;
    }
    ;
    if (i < 22 && grid[i + 1][j] == 'X') {
        nn++;
    }
    ;
    if (i < 22 && j < 72 && grid[i + 1][j + 1] == 'X') {
        nn++;
    }

    return nn;
}