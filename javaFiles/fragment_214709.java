// ONLY if you use ASCII as Charset
public static String convert(String s) {
    Charset ASCII = Charset.forName("ASCII");
    byte[] bytes = s.getBytes(ASCII);
    byte[] convert = new byte[bytes.length];

    for (int i = 0; i < bytes.length; i++) {
        convert[i] = (byte) (~bytes[i] & 0x7F);
    }

    return new String(convert, ASCII);
}