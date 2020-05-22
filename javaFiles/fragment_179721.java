int row = m - 1;

while (row--) {        
    a[row][0] += max(a[row + 1][0], a[row + 1][1]);

    for (int col = 1; col < row + 1; col++) {
        int a1 = a[row + 1][col - 1];
        int a2 = a[row + 1][col];
        int a3 = a[row + 1][col + 1];

        a[row][col] += max(a1, a2, a3);
    }
}