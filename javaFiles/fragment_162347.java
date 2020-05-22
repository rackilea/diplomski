public enum Delimiter {
    COMMA(','), SEMI(';'), PIPE('|'), COLON(':');

    public final char c;
    public final Pattern pattern;

    private DelimiterChar(final char c) {
        this.c = c;
        this.pattern = Pattern.compile(Pattern.quote(Character.toString(c)));
    }
}