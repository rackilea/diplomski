int[][] array = new int[rows][columns];
for(int i = 0; i < rows, i++) {
    for(int j = 0; j < columns; j++) {
        array[i][j] = j * rows + i + 1;
    }
}