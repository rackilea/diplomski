public static String crypt(String s) {
    byte[] bytes = s.getBytes();
    for (int i = 0; i < bytes.length; i++)
        bytes[i] = (byte) (bytes[i] ^ KEY);
    return new String(bytes);
}