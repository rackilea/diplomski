public static void main(String[] args) throws IOException {
    double[][] array = new double[][]{{1d,1d,1d},{2d,2d,2d},{3d,3d,3d}};
    double[][] subArray = get2DSubArray(array, 1, 2, 1, 2);
    for(double[] arrayElement : subArray){
        for(double number : arrayElement){
            System.out.println(number);
        }
    }
}

public static double[][] get2DSubArray(double[][] largeArray, int rowStartIndex, int rowEndIndex, int columnStartIndex,
        int columnEndIndex) {
    double[][] subArray = new double[rowEndIndex - rowStartIndex + 1][columnEndIndex - columnStartIndex + 1];
    for (int row = rowStartIndex; row < rowEndIndex; row++) {
        subArray[row] = Arrays.copyOfRange(largeArray[row], columnStartIndex, columnEndIndex);
    }
    return subArray;
}