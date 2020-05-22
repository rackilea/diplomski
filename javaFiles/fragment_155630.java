public static void quickSort(int anArray[], int position, int pivot) {

    if (isSorted(anArray, position, pivot + 1)) {
        return;
    }

    //...
}


private static boolean isSorted(int[] a, int start, int end) {
    for (int i = start+1; i < end; i++) {
        if (a[i] < a[i-1]) {
            return false;
        }
    }
    return true;
}