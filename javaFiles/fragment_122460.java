public int partition(int pAR[], int start, int end) {
    int pivot = pAR[end];
    int pIndex = start;
    for (i = start; i < end; i++) {
        if (pAR[i] <= pivot) {
            swap(pAR, i, pIndex);
            pIndex++;
        }
    }
    swap(pAR, pIndex, end);
    return pIndex;
}

public void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}