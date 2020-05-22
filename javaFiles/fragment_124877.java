public static String tohex(byte[] data) {
    StringBuilder sb = new StringBuilder(data.length * 2);
    for (int i = 0; i < data.length; i++) {
        sb.append(String.format("%02X", data[i] & 0xFF));
    }
    return sb.toString();
}