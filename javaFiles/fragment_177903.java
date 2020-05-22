public static int[] collapse(int[] old) {
    int[] nNew = new int[(old.length + 1) / 2];
    for (int i = 0; i < old.length; i += 2) {
        nNew[i / 2] = old[i];
        if (i + 1 < old.length) {
            nNew[i / 2] += old[i + 1];
        }
    }
    return nNew;
}