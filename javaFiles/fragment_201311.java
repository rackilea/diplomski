public static int bsearch(int[] arr, int key) {
    int lo = 0, hi = arr.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (arr[mid] <= key)
            lo = mid + 1;
        if (arr[mid] > key)
            hi = mid;
    }

    if (arr[lo] == key) {
        return lo;
    }
    else {
        return lo - 1;
    }
}