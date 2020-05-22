public static void reverse(byte[] array) {
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
        byte b = array[i];
        array[i] = array[j];
        array[j] = b;
    }
}