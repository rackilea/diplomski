public IntMatrix(int[][] array) {
    matrix = new int[array.length][];
    for (int i = 0; i < array.length; i++) {
        matrix[i] = new int[array[i].length];
        for(int j=0; j < array[i].length; j++) {
            matrix[i][j] = array[i][j];
        }
    }
}