public static int hashCode(byte a[]) {
    if (a == null) return 0;
    int result = 1;
    for (byte element : a) result = 31 * result + element;
    return result;
}