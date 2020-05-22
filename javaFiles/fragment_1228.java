public static boolean isAtop2spots1(int A, int b, int c, int d) {
    if (A > b) {
        if (A > c) return true;
        if (A > d) return true;
    }
    if (A > c) {
        if (A > b) return true;
        if (A > d) return true;
    }
    return false;
}