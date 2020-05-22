public Object[][] matrixize(int cutat, Object... data) {
    int rows = (int) Math.ceil(data.length / (double) cutat);
    Object[][] matrix = new Object[rows][cutat];
    int matrIndex = 0, i = 0;
    for (; i < data.length-1; i++) {
        for (int j=0; j < cutat; j++) {
            matrix[matrIndex][j] = data[i];
            i++;
        }
        matrIndex++;
        --i;
    }
    if(i<data.length) matrix[matrIndex] = new Object[]{data[i]};
    return matrix;
}