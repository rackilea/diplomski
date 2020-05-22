public static int[] interleave(int[] a, int[] b) {
    int[] out = new int[a.length + b.length];
    int j = 0;
    int maxLength = Math.max(a.length, b.length);
    for (int i = 0; i < maxLength; i++) {
        if (i < a.length) {
            out[j++] = a[i];
        }
        if (i < b.length) {
            out[j++] = b[i];
        }
    }
    return out;
}