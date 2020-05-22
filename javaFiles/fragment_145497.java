public double[][] getResult(double[] data, int rowSize) {
    int columnSize = data.length;
    double[][] result = new double[rowSize][columnSize];
    for (int i = 0; i < columnSize; i++) {
        result[0][i] = data[i];
    }
    return result;
}