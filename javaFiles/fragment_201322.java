public static void setDefaultEbcidicCharacterset(String charset) {
    if (getHold(charset).isEbcdic) {
        byte[] b = {(byte) 0xC0, (byte) 0xD0};
        String s = new String(b, charset);
        if (s.length() == 2) {
            positive0EbcdicZoned = s.charAt(0);
            negative0EbcdicZoned = s.charAt(1);
        }
    }
}