private int[][] copyArray(int begin, int end) {
    // Calculate the size of the output
    // below the '+1' is due to zero-indexing
    int size = end - begin + 1;
    int[][] arrayOfVals = new int[size][];
    for (int i = 0; i < size; i++) {
        // Clone each subarray to make sure changes to the copy
        // don't affect the internal array
        // (A shallow .clone() suffices for integer arrays)
        arrayOfVals[i] = partitionResult[begin + i].clone();
    }
    return arrayOfVals;
}