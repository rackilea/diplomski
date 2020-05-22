private final static String HEX_CHARS = "0123456789ABCDEF";

@Override
public String toString() {
    String res = "";
    for(byte b : data) {
        res += HEX_CHARS.charAt((b >> 4) & 0xF);
        res += HEX_CHARS.charAt(b & 0xF);
    }
    return res;
}