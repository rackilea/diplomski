char[][] a = new char[4][4];

for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
        a[i][j] = s.charAt(4 * i + j);
    }
}