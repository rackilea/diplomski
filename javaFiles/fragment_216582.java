public enum Color {
    RED  ("Red"),
    GREEN("Green"),
    BLUE ("Blue");

    private final String displayText;

    private Color(String displayText) {
        this.displayText = displayText;
    }
    public String getDisplayText() {
        return this.displayText;
    }
    @Override
    public String toString() {
        return this.displayText;
    }
}