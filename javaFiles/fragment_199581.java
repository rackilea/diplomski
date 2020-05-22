public static int[] leftShift(int[] a) {
    int[] r = new int[a.length];
    for (int i = 0; i < a.length - 1; i++)
        r[i] = a[i+1];
    r[a.length - 1] = a[0];
    return r;
}