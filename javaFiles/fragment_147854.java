private static String encodeSignedNumber(int num) {
    int sgn_num = num << 1;
    if (num < 0) {
        sgn_num = ~(sgn_num);
    }
    return(encodeNumber(sgn_num));
}

private static String encodeNumber(int num) {

    StringBuffer encodeString = new StringBuffer();

    while (num >= 0x20) {
        encodeString.append((char)((0x20 | (num & 0x1f)) + 63));
        num >>= 5;
    }

    encodeString.append((char)(num + 63));

    return encodeString.toString();

}