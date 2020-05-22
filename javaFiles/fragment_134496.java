public static int lastIndexOf(int[] a, int v) {
    for (int i = a.length-1; i >= 0; i--)
        if (a[i] == v)
            return i;
    return -1;
}