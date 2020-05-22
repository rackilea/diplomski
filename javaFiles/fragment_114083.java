public static int[] noDupes(int[] a) {
    Arrays.sort(a);
    int noDupCount = 0;
    for (int i = 0; i < a.length; i++) {
        if (i == 0 || a[i] != a[i - 1]) {
            noDupCount++;
        }
    }
    int[] a2 = new int[noDupCount];
    for (int i = 0, j = 0; i < a.length; i++) {
        if (i == 0 || a[i] != a[i - 1]) {
            a2[j++] = a[i];
        }
    }
    return a2;
}