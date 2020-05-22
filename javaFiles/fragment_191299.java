public int getMaxIndex(int endIndex, int[] a) {
    int max = a[0];
    int maxIndex = 0;
    for (int i = 1; i <= endIndex; i++) {   // use <= instead of <
        if (a[i] > max) {                   // change < in >
            max = a[i];
            maxIndex = i;
        }
    }
    return maxIndex;
}