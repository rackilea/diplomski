public void coalesce(Object[] a, Object mask) {
    if (a[0] == null) {
        a[0] = mask;
    }
    for (int i = 1; i < a.length; i++) {
        if (a[i] == null) {
            a[i] = a[i-1];
        }
    }
}