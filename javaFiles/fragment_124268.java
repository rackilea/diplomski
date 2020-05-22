private static String hashString(String s) 
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] digest = md.digest(s.getBytes("US-ASCII"));

    byte[] sub1 = Arrays.copyOfRange(digest, 0, 4);
    byte[] sub2 = Arrays.copyOfRange(digest, 4, 8);
    byte[] sub3 = Arrays.copyOfRange(digest, 8, 12);
    byte[] sub4 = Arrays.copyOfRange(digest, 12, 16);
    int x1 = java.nio.ByteBuffer.wrap(sub1).getInt();
    int x2 = java.nio.ByteBuffer.wrap(sub2).getInt();
    int x3 = java.nio.ByteBuffer.wrap(sub3).getInt();
    int x4 = java.nio.ByteBuffer.wrap(sub4).getInt();

    return DatatypeConverter.printHexBinary(java.nio.ByteBuffer.allocate(4)
            .putInt(x1 ^ x2 ^ x3 ^ x4).array());
}