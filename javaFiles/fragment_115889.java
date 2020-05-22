public static void convert(int[] array, char[] array1) {
    int length = array.length;
    for (int i = 0; i < length; i++) {
        // this converts a integer into a character
        array1[i] = (char) array[i];
    }
}