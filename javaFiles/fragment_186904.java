int sign(int i) {
    if (i == 0) return 0;
    if (i >> 31 != 0) return -1;
    return +1;
}
int sign(long i) {
    if (i == 0) return 0;
    if (i >> 63 != 0) return -1;
    return +1;
}
int sign(double f) {
    if (f != f) throw new IllegalArgumentException("NaN");
    if (f == 0) return 0;
    f *= Double.POSITIVE_INFINITY;
    if (f == Double.POSITIVE_INFINITY) return +1;
    if (f == Double.NEGATIVE_INFINITY) return -1;

    //this should never be reached, but I've been wrong before...
    throw new IllegalArgumentException("Unfathomed double");
}