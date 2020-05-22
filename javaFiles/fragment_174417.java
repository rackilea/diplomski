static String bin2hex(byte[] data) {
    StringBuilder hex = new StringBuilder(data.length * 2);
    for (byte b : data)
        hex.append(String.format("%02x", b & 0xFF));
    return hex.toString();
}