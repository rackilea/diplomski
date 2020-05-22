public void parseTokens() {
    switch (tokensLeft) {
        case 3:
            parseThreeTokens(rawListener, tokens);
            break;
        case 2:
            parseTwoTokens(rawListener, tokens);
            break;
        default:
            throw new IllegalArgumentException("Method call binaryInfo could not be done because: \"Wrong number of parameters\"");
    }
}

public void parseThreeTokens(final RawListener rawListener, final Tokens tokens) {
    final String id = tokens.nextToken();
    final String value = tokens.nextToken();
    final String trailerId = tokens.nextToken();
    rawListener.binaryInfo(id, parseInt(value), trailerId, this);

}

public void parseTwoTokens(final RawListener rawListener, final Tokens tokens) {
    final String id = tokens.nextToken();
    final String value = tokens.nextToken();
    rawListener.binaryInfo(id, parseInt(value), this);
}