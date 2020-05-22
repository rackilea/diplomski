int[][] createArray(int d1, int d2) {
    int[][] ret = new int[d1][];
    for (int i = 0; i < d1; i++) {
        ret[i] = new int[d2];
    }
    return ret;
}