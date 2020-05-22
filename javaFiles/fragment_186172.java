public void metaIS(int[] a, int i) {
    IS(a, 0);
    if (i < a.length) {
        metaIS(a, i + 1);
    }
}