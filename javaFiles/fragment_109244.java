public static String convertToBase64(int[] ints) {
    byte[] bytes = new byte[ints.length];
    for (int i = 0; i < ints.length; i++) {
        bytes[i] = (byte)ints[i];
    }
    return Base64.getEncoder().encodeToString(bytes);
}