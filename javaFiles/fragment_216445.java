public static String decode(String hexCodes, String encoding) throws UnsupportedEncodingException {
    if (hexCodes.length() % 2 != 0)
        throw new IllegalArgumentException("Illegal input length");
    byte[] bytes = new byte[hexCodes.length() / 2];
    for (int i = 0; i < bytes.length; i++)
        bytes[i] = (byte) Integer.parseInt(hexCodes.substring(2 * i, 2 * i + 2), 16);
    return new String(bytes, encoding);
}

public static void main(String[] args) throws UnsupportedEncodingException {
    String hexCodes = "005400610020007400650020007400ED0020007400FA0020003F0020003A0029";
    System.out.println(decode(hexCodes, "UTF-16"));
}