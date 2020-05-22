public void selectionSort(int[] a, int k) {
    if (k == 0) {
        return;
    }
    else {
        selectionSort(a, k-1 );
        find x such that a[x] is the smallest of a[k] ... a[a.length - 1]
        if (a[k-1] > a[x]) {
            swap a[k-1] and a[x]
        }
    }
}