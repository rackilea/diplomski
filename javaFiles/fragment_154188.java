public static int max(int first, int... rest) {
    int ret = first;
    for (int val : rest) {
        ret = Math.max(ret, val);
    }
    return ret;
}