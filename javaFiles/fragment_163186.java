public enum State {
    ON,
    OFF,
    UNKNOWN;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}