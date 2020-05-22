int[] values = new int[array1.length];
for (int i = 0; i < values.length; i++) {
    int fromX = array1[i][0];
    int fromY = array1[i][1];
    int toX = array1[i][2];
    int toY = array1[i][3];

    for (int x = fromX; x <= toX; x++) {
        for (int y = fromY; y <= toY; y++) {
            values[i] += array2[x][y];
        }
    }
}