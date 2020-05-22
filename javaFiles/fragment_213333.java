public static boolean increasing(int[] x, int length) {
    return increasing(x, length, x[0], 0, 0) >= length;
}

private static int increasing(int[] x, int length, int min, int i, int from) {
    if (i >= x.length)
        return 0;    

    int res = increasing(x, length, Math.max(min, x[i]), i + 1, from);

    if (x[i] >= min)
        res++;    
    if (i != from || res >= length || i + length > x.length)
        return res;
    return increasing(x, length, x[i + 1], i + 1, i + 1);
}