private boolean peekIdentifierToken(String identifierString) {
        if (!moreTokens()) {
            return false;
        }
        Token t = peekToken();
        return t.kind==TokenKind.IDENTIFIER && t.stringValue().equalsIgnoreCase(identifierString);
}