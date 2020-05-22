private static void movedown(double [] a, int k, int c) {
    while (2*k <= c-1) {
        int j = 2*k+1;
        if (j <= c-1 && less(a[j], a[j+1])) j++;
        if (!less(a[k], a[j])) break;
        exch(a, k, j);
        k = j;
    }
}

public static void heapsort(double [] a, int count) {
    for (int k = count/2; k >= 0; k--)
        movedown(a, k, count);
    while (count >= 1) {
        exch(a, 0, count--);
        movedown(a, 0, count);
    }
}