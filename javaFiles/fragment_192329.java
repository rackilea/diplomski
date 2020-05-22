public static String concat(String... strs) {
    int size = 0;
    for (String str : strs) {
        size += str.length;
    }

    final char[] cs = new char[size];
    int off = 0;
    try {
        for (String str : strs) {
            int len = str.length();
            str.getChars(0, len, cs, off);
            off += len;
        }
    } catch (ArrayIndexOutOfBoundsException exc) {
        throw new ConcurrentModificationException(exc);
    }
    if (off != cs.length) {
        throw new ConcurrentModificationException();
    }
    return new String(cs);
}