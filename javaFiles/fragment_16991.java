public static int[] multiplyArrayValues (int [] values) {
    int[] a = new int[values.length];
    int p = 1;
    for (int i = values.length - 1; i >= 0; i--) {
        a[i] = p;
        p *= values[i];
    }
    p = 1;
    for (int i = 0; i < values.length; i++) {
        a[i] *= p;
        p *= values[i];
    }
    return a;
}