public <T> T[] wrap(T x) {
    T[] a = (T[]) Array.newInstance(x.getClass(), 1);
    a[0] = x;
    return a;
}

public <T> T[] concatenate (T[] a, T[] b) {
    T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);
    System.arraycopy(a, 0, c, 0, a.length);
    System.arraycopy(b, 0, c, a.length, b.length);
    return c;
}