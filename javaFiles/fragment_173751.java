public static String escapeForQuotes(String s) {
    return escapeForQuotes(s, '\uFFFF');
}

public static String escapeForQuotes(String s, char ignore) {
    int len = s.length();
    StringBuilder sb = new StringBuilder(len * 6 / 5);
    for (int i = 0; i < len; i++) {
        char c = s.charAt(i);
        if (c == ignore) { sb.append(c); continue; }
        switch (c) {
        case '\\': case '\"': case '\'': break;
        case '\n': c = 'n'; break;
        case '\r': c = 'r'; break;
        case '\0': c = '0'; break;
        default: sb.append(c); continue;
        }
        sb.append('\\').append(c);
    }
    return sb.toString();
}