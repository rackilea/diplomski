int newSize = rows * cols;
int[] indexes = new int[rows];
double[] sortedArray = new double[newSize];
for (int i = 0; i < newSize; i++){
    int minIndex = -1;
    double minValue = Double.MAX_VALUE;
    for (int j = 0; j < rows; j++) {
        if (indexes[j] < cols && matrix[j][indexes[j]] < minValue){
            minValue = matrix[j][indexes[j]];
            minIndex = j;
        }
    }
    sortedArray[i] = minValue;
    indexes[minIndex]++;
}