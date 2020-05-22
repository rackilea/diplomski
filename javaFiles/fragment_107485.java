byte[] getBytes(String s) {
    byte[] a = new byte[s.length() / 2];
    for (int i = 0; i < a.length; i++) {
        a[i] = Byte.parseByte(s.substring(i * 2, i * 2 + 2), 16);
    }
    return a;
}