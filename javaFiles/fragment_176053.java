public double[] getShinkedArray(final double[] my_input_array, final int... positions) {
    double[] outputArray = new double[my_input_array.length - positions.length];
    for (int i = 0, j = 0; i < my_input_array.length; i++) {
        if (Arrays.binarySearch(positions, i) < 0) {
            outputArray[j++] = my_input_array[i];
        }
    }
    return outputArray;
}