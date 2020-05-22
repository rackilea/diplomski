public static int[][] getRows(int i, int j, int[][] array) {
    int[][] ret = new int[j - i][];
    for (int k = i; k < j; k++) {
        ret[k - i] = new int[array[k].length];
        for (int m = 0; m < ret[k - i].length; m++) {
            ret[k - i][m] = array[k][m];
        }
    }
    return ret;
}