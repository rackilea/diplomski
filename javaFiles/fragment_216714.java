private static final class TokenMatcher {
    private final Pattern p;
    private final Token t;
    public TokenMatcher(String pString, Token t) {
        p = Pattern.compile(pString);
        this.t = t;
    }
    public Token match(String s) {
        Matcher m = p.matcher(s);
        return m.matches() ? t: null;
    }
}