public enum Comparison {
    EQ("="), GTE(">="), GT(">"), LT("<"), LTE("<=");

    private final String value;

    private Comparison(String text) {
        this.value = text;
    }

    public String getValue() {
        return this.value;
    }
}