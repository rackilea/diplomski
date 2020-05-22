public static String betweenMatchedBrackets(
     String str, char open, char close
) {
    int start = str.indexOf(open);
    if (start == -1) {
        return null;
    }

    ++start;
    int strLen = str.length();
    char[] cs = new char[strLen-start]; // Assume typically much of string
    strLen.getChars(start, len, cs, 0);

    int foundLen = endingBracket(cs, open, closed);
    return foundLen != cs.length ? str.substring(start, start+foundLen) : null;
}
private static int endingBracket(char cs, char open, char closed) {
    int depth = 1;
    int i = 0;
    for (; depth != 0 && i != cs.length; ) {
        i = nextInteresting(cs, i, open, close);
        if (i != cs.length) {
            char c = cs[i];
            depth += c==open ? 1 : -1;
        }
    }
    return int;
}
private static int nextInteresting(char[] cs, int off, char open, char close) {
    for (; off != cs.length && cs[off] != open && cs[off] != close; ++off) {
    }
    return off;
}