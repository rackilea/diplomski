static int[] rotLeft(int[] a, int d) {
    if (d < 0 || a == null || a.length == 0) {
        throw new IllegalArgumentException();
    }

    int shift = d % a.length;
    if (shift == 0) {
        return a;
    }
    int[] result = new int[a.length];
    System.arraycopy(a, shift, result, 0, a.length - shift);
    System.arraycopy(a, 0, result, a.length - shift, shift);
    return result;
}