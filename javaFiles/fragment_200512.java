public static void main(String[] args) throws Exception {
    byte[] b = new byte[256];
    for (int i = 0; i < b.length; i++) {
        b[i] = (byte) i;
    }
    String s = new String(b, "ISO-8859-1");
    byte[] b2 = s.getBytes("ISO-8859-1");
    System.out.println("Are the bytes equal : " + Arrays.equals(b, b2));
}