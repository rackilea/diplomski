public static int recursive(int x) {
    return recursive(x, 2);
}

private static int recursive(int x, int factor) {
    if (factor >= x)
        return 0;
    if (x % factor == 0)
        return 1 + recursive(x, factor + 1);
    return recursive(x, factor + 1);
}