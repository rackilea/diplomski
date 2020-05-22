private interface TokenMatcher {
    Token match(String s);
}
static List<TokenMatcher> matchers = new ArrayList<>();
static {
    final Pattern strPattern = Pattern.compile("[a-z]+");
    final Pattern numPattern = Pattern.compile("[0-9]+");
    matchers.add( new TokenMatcher {
        public Token match(String s) {
            Matcher m = strPattern.matcher(s);
            return m.matches() ? Token.STRING : null;
        }
    });
    matchers.add( new TokenMatcher {
        public Token match(String s) {
            Matcher m = numPattern.matcher(s);
            return m.matches() ? Token.NUMBER : null;
        }
    });
}