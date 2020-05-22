public static int[] reverse(int[] a, int number) {
    // negative case
    if (number < 0) {
        return a;
    }
    // higher count than array length
    int size = number < a.length ? number : a.length;
    int[] b = new int[size];
    System.arraycopy(a, 0, b, 0, size);
    for (int i = b.length - 1; i >= 0; i--) {
        a[b.length - 1 - i] = b[i];
    }
    return a;
}