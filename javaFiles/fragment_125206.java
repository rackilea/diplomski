private static String rotateLeft(String text, int count) {
    char[] buf = text.toCharArray();
    for (int i = 0; i < buf.length; i++)
        buf[i] = (char)((buf[i] - 'A' + 26 - count) % 26 + 'A');
    return new String(buf);
}