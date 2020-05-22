private static long[][] remove(long[][] array, int value) {
    boolean found = false;
    int emptyIndex = -1;
    for (int i = 0; i < array.length; i++) {
        long[] sub = array[i];
        for (int j = 0; j < sub.length; j++) {
            if (sub[j] == value) {
                long[] newSub = new long[sub.length - 1];
                System.arraycopy(sub, 0, newSub, 0, j);
                System.arraycopy(sub, j + 1, newSub, j, sub.length - j - 1);
                array[i] = newSub;
                if (array[i].length == 0) emptyIndex = i;
                found = true;
                break;
            }
        }
        if (found) break;
    }
    if (emptyIndex >= 0) {
        long[][] newArray = new long[array.length - 1][];
        System.arraycopy(array, 0, newArray, 0, emptyIndex);
        System.arraycopy(array, emptyIndex + 1, newArray, emptyIndex, array.length - emptyIndex - 1);
        array = newArray;
    }
    return array.length == 0 ? null : array;
}