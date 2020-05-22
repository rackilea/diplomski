public static Integer decode(String nm) throws NumberFormatException {
    // some code
    result = Integer.valueOf(nm.substring(index), radix);
    // in our case Integer.valueOf("cafebabe", 16)
    // some code
}

public static Integer valueOf(String s, int radix) throws NumberFormatException {
    return Integer.valueOf(parseInt(s,radix));
}

public static int parseInt(String s, int radix) throws NumberFormatException {
    // some code
    // limit == -Integer.MAX_VALUE == -2147483647
    // multmin == -134217727
    int multmin = limit / radix;
    int result = 0;
    while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        int digit = Character.digit(s.charAt(i++), radix);
        if (digit < 0 || result < multmin) {
            throw NumberFormatException.forInputString(s);
        }
        result *= radix;
        if (result < limit + digit) {
            throw NumberFormatException.forInputString(s);
        }
        result -= digit;
    }
    // some code
}