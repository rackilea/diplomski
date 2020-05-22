public static boolean hasNumber(int t1, int t2, int t3) {
    return isInRange(t1) || isInRange(t2) || isInRange(t3);
}

private static boolean isInRange(int t) {
    return t >= 13 && t <= 19;
}