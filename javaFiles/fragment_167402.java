public static byte[] toByteArray(String strPacket) {
    int len = strPacket.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(strPacket.charAt(i), 16) << 4)
                + Character.digit(strPacket.charAt(i + 1), 16));
    }
    return data;
}