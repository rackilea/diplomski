private static void insertAfter(long[][] array, int value, long[] insertion) {
    boolean found = false;
    for (int i = 0; i < array.length; i++) {
        long[] sub = array[i];
        for (int j = 0; j < sub.length; j++) {
            if (sub[j] == value) {
                long[] newSub = new long[sub.length + insertion.length];
                System.arraycopy(sub, 0, newSub, 0, j + 1);
                System.arraycopy(insertion, 0, newSub, j + 1, insertion.length);
                System.arraycopy(sub, j + 1, newSub, j + 1 + insertion.length, sub.length - j - 1);
                array[i] = newSub;
                found = true;
                break;
            }
        }
        if (found) break;
    }
}