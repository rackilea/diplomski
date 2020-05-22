static Token match(String s) {
    for (TokenMatcher m : matchers) {
        Token t = m.match(s);
        if (t != null) {
            return t;
        }
    }
    return TOKEN.UNKNOWN;
}