public static byte[] intToBytes(int number, int digits) {
    byte[] results = new byte[digits];
    /* Start at the end of the array. i.e. 1234, should be converted to {1, 2, 3, 4} */
    for (int i = digits - 1; i >= 0; i--) {
        results[i] = (byte) (number % 10);
        number = number / 10;
    }
    return results;
}