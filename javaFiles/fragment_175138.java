public <T> T[][] concatenate (T[] a, T[][] b) {
    T[][] c = (T[][]) Array.newInstance(a.getClass(), b.length + 1);
    c[0] = a;
    System.arraycopy(b, 0, c, 1, b.length);
    return c;
}