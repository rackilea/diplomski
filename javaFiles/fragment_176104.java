public static String prepend(CharSequence sequence, CharMatcher charMatcher, CharSequence toPrepend) {
    if (toPrepend.length() == 0) {
        return sequence.toString();
    }

    String string = sequence.toString();
    int pos = charMatcher.indexIn(string);
    if (pos == -1) {
        return string;
    }

    int len = string.length();
    StringBuilder buf = new StringBuilder((len * 3 / 2) + 16);

    int oldpos = 0;
    do {
        buf.append(string, oldpos, pos);
        buf.append(toPrepend);
        buf.append(string.charAt(pos));
        oldpos = pos + 1;
        pos = charMatcher.indexIn(string, oldpos);
    } while (pos != -1);

    buf.append(string, oldpos, len);
    return buf.toString();
}