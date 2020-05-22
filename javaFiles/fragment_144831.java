public int lastIndexOf(int ch, int fromIndex) {
    int min = offset;
    char v[] = value;

    int i = offset + ((fromIndex >= count) ? count - 1 : fromIndex);

    if (ch < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
        // handle most cases here (ch is a BMP code point or a
        // negative value (invalid code point))
        for (; i >= min ; i--) {
            if (v[i] == ch) {
                return i - offset;
            }
        }
        return -1;
    }

    int max = offset + count;
    if (ch <= Character.MAX_CODE_POINT) {
        // handle supplementary characters here
        char[] surrogates = Character.toChars(ch);
        for (; i >= min; i--) {
            if (v[i] == surrogates[0]) {
                if (i + 1 == max) {
                    break;
                }
                if (v[i+1] == surrogates[1]) {
                    return i - offset;
                }
            }
        }
    }
    return -1;
}