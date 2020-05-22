public static void selectionSort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
        int min = i;
        for (int j = i + 1; j < n; j++) {
            if (a[j] < a[min]) {
                min = j;
                int swap = a[i];
                a[i] = a[min];
                a[min] = swap;
            }
        }
    }
}