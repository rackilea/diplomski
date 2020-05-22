private static byte[] getBytesUTF16LE(String str) {
    final int length = str.length();
    final char buffer[] = new char[length];
    str.getChars(0, length, buffer, 0);
    final byte b[] = new byte[length*2];
    for (int j = 0; j < length; j++) {
        b[j*2] = (byte) (buffer[j] & 0xFF);
        b[j*2+1] = (byte) (buffer[j] >> 8);
    }
    return b;
}