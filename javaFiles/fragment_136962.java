private static class Token {
    final TokenType type;
    final int start; // start position in input (for error reporting)
    final String data; // payload

    public Token(TokenType type, int start, String data) {
        this.type = type;
        this.start = start;
        this.data = data;
    }

    @Override
    public String toString() {
        return type + "[" + data + "]";
    }
}