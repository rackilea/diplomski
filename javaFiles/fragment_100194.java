public static byte[] converting(byte[] value) {
    final int length = value.length;
    byte[] res = new byte[length];
    for(int i = 0; i < length; i++) {
        res[length - i - 1] = value[i];
    }
    return res;
}