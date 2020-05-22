public static byte[] removeTrailingNulls(byte[] source) {
    int i = source.length;
    while (source[i - 1] == 0x00) {
        i--;
    }

    byte[] result = new byte[i];
    System.arraycopy(source, 0, result, 0, i);

    return result;
}