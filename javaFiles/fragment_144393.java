public enum Color {
    BLUE,
    GREEN,
    RED,
    YELLOW;

    public Color next() {
        return Color.values()[ (this.ordinal() + 1) % Color.values().length ];
    }
}