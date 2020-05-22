public double[][] get2DSubArray(double[][] largeArray, int rowStartIndex, int rowEndIndex, int columnStartIndex,
        int columnEndIndex) {
    double[][] subArray = new double[rowEndIndex - rowStartIndex + 1][columnEndIndex - columnStartIndex + 1];
    int index = 0;
    for (int row = rowStartIndex; row <= rowEndIndex; row++) {
        subArray[index++] = Arrays.copyOfRange(largeArray[row], columnStartIndex, columnEndIndex+1);
    }
    return subArray;
}