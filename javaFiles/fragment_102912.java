public static String hexString2String(String src) {
    byte[] data = new byte[src.length() / 2];
    for (int i = 0; i < src.length() / 2; i++) {
        data[i] = Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
    }
    return new String(data, StandardCharsets.UTF_16LE);
}