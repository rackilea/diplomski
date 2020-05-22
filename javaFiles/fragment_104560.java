private static char toHex(int nibble) {
        final char[] hexDigit = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        return hexDigit[nibble & 0xF];
    }
    public static String toHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length*2);
        for(int i = 0; i < bytes.length; i++) {
            sb.append(toHex(bytes[i] >> 4) );
            sb.append(toHex(bytes[i]) );
        }
        return sb.toString();
    }