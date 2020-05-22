public enum CellType {
    EMPTY("", "default-box"),
    START("Start", "start-end"),
    END("End", "start-end"),
    WALL("", "wall");

    private final String styleClass;
    private final String text;

    CellType(String text, String styleClass) {
        this.text = text;
        this.styleClass = styleClass;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public String getText() {
        return text;
    }

    public Values inverted() {
        // this requires the values to be kept in this order
        CellType[] vals = values();
        return vals[vals.length - 1 - ordinal()];
    }
}