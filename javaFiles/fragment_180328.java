private int partition(int[] arr, int lo, int hi) {
    int pivotIndex = hi; // last element
    int j = lo;

    for (int i = lo; i < hi; i++) {
        if (arr[i] < arr[pivotIndex]) {
            swap(arr, j, i);
            j++;
        }
    }
    swap(arr, j, pivotIndex);
    return j;
}