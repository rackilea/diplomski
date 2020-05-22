public static long getUnsignedInt(byte[] data) {
    long result = 0;

    for (int i = 0; i < data.length; i++) {
        result += data[i] << 8 * (data.length - 1 - i);
    }
    return result;
}