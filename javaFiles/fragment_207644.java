public static String escapeChars(String str) {
    char[][] escapes = {
            { '\n', 'n' },
            { '\r', 'r' },
            { '\f', 'f' },
            { '\b', 'b' },
            { '\t', 't' }
    };
    for (char[] escape : escapes) {
        str = str.replaceAll(Character.toString(escape[0]), "\\\\" + escape[1]);
    }
    return str;
}