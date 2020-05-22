private static int[] addToArray(int[] data, int x) {
    int[] array2 = growArray(data);
    if (data != null) {
        System.arraycopy(data, 0, array2, 0, data.length);
    }
    array2[array2.length - 1] = x;
    return array2;
}