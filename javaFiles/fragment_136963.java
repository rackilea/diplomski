private static TokenStream tokenize(String input) throws ParseException {
    Matcher matcher = TOKENS.matcher(input);
    List<Token> tokens = new ArrayList<>();
    int offset = 0;
    TokenType[] types = TokenType.values();
    while (offset != input.length()) {
        if (!matcher.find() || matcher.start() != offset) {
            throw new ParseException("Unexpected token at " + offset, offset);
        }
        for (int i = 0; i < types.length; i++) {
            if (matcher.group(i + 1) != null) {
                if (types[i] != TokenType.WHITESPACE)
                    tokens.add(new Token(types[i], offset, matcher.group(i + 1)));
                break;
            }
        }
        offset = matcher.end();
    }
    tokens.add(new Token(TokenType.EOF, input.length(), ""));
    return new TokenStream(tokens);
}