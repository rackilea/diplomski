public static String asId(long number) {
    long lowBit = number & 1;
    long highBits = number >>> 1;
    return (char) ('a' + highBits % 13 + lowBit) 
        + (number >= 26 ? Long.toString(highBits / 13, 36) : "");
}