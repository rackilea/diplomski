void swap(Object[] a, int i, int j) {
    Object tmp = a[i];
    a[i] = a[j];
    // Now the original reference a[i] is in a register only.
    a[j] = tmp;
}