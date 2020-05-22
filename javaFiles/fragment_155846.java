public void swap (String [] array, int i, int j) {
    String tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
}

public static int partition (String [] array, int low, int high) {
    String pivot = array[low];
    int index = low+1;
    for (int i = low+1; i <= high; i++) {
        if (pivot.compareTo(array[i]) > 0) {
            swap(array, i, index);
            index++;
        }
    }
    swap(array, low, index-1);
    return index-1;
}

public static void qsort(String [] array, int low, int high) {
    if (low < high) {
        int p = partition(array, low, high);
        qsort(array, low, p);
        qsort(array, p+1, high);
    }
}