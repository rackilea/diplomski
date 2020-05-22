public static void quickSort(int start, int end, int[] arr) {
    if (start < end) {
        int partitionIndex = partition(start, end, arr);
        quickSort(start, partitionIndex - 1, arr);
        quickSort(partitionIndex + 1, end, arr);
    }
}

public static int partition(int start, int end, int[] arr) {
    int pivot = arr[end];
    int pIndex = start;
    for (int i = start; i < end; i++) {
        if (arr[i] < pivot) {
            swap(pIndex, i, arr);
            pIndex++;
        }
    }
    swap(pIndex, end, arr);
    return pIndex;
}