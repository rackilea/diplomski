public static void heapMe(int n) {
    int kk;
    for (kk = n / 2 - 1; kk >= 0; kk--) {
        heapify(Arr, n, kk);
    }
}

public static void heapify(int[] Arr, int n, int i) {
    ... // Replace Arr.length with n throughout the body of the function
}