static String addLeadingZeroes(String s) {
    int zeroes = s.length() % 8;
    byte[] bzero = new byte[8 - zeroes];
    Arrays.fill(bzero, (byte)0x30);
    return new StringBuilder(new String(bzero)).append(s).toString();
}