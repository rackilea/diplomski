private static void intToChar(char[] array, int input) {
    int i = array.length - 1;
    while (input > 0 && i >= 0) {
        array[i--] = (char) (48 + input % 10);
        input /= 10;
    }
}