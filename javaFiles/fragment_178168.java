public enum SomeChar {
    X('X'), Y('Y');

    public char asChar() {
        return asChar;
    }

    private final char asChar;

    SomeChar(char asChar) {
        this.asChar = asChar;
    }
}