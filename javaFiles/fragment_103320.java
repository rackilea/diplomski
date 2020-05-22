public static int getUniqueElement(int[] a, int[] b) {
    int ret = 0;
    int i;
    for (i = 0; i < a.length; i++) {
        ret = ret ^ a[i] ^ b[i];
    }
    return ret ^ b[i];
}