for (int row = 1; row < I.length; row++) {
    for (int col = 0; col < I[row].length; col++) {
        int x = I[row][col];
        int y = I[row - 1][col];
        GLCM[x][y]++;
    }
}