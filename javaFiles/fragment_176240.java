public static byte[] intToBytes(int number, int digits) {
    String format = "%0" + digits + "d";
    String numberAsString = String.format(format, number);
    char[] numberAsCharArray = numberAsString.toCharArray();
    byte[] result = new byte[digits];
    for (int i = 0; i < numberAsCharArray.length; i++) {
        result[i] = (byte) numberAsCharArray[i];
    }
    return result;
}