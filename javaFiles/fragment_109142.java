int[][][2] table = new int[7][4][2]; // <== Remove 2
for (int i = 0; i < 7; i++) {
    for (int j = 0; i < 4; j++) {    // <== Change i to j
        table[i][j][1] = 2;          // <== Arrays are zero-based
        table[i][j][2] = 5;          // <== -
    }
}