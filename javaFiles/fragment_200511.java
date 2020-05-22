public static void main(String[] args) throws Exception {
    byte[] b = new byte[] {(byte) 0x00, (byte) 0xf6};
    String s = new String(b, "ISO-8859-1"); // decoding
    byte[] b2 = s.getBytes("ISO-8859-1"); // encoding
    System.out.println("Are the bytes equal : " + Arrays.equals(b, b2)); // true
}