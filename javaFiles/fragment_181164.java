private static void selectionSort(int fromIndex, int[] array) {
    int currentMin = array[fromIndex];
    int indexOfMin = fromIndex;

    for(int j = fromIndex+1; j < array.length; j++) {
        if(array[j] < currentMin) {
            currentMin = array[j];
            indexOfMin = j;
        }
    }
    swap(array, fromIndex, indexOfMin);
}

private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}