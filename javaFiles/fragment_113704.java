private enum TimeConstants {
    FIVE_MINUTES("5 Minutes", 5),
    TEN_MINUTES("10 Minutes", 10);

    private final String text;
    private final int value;

    private TimeConstants( String text, int value ) {
        this.text = text;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.text;
    }
}