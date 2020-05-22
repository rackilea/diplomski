public enum ColourSet {
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    RED(Color.RED),
    YELLOW(Color.YELLOW);

    private final java.awt.Color color;

    private ColourSet(java.awt.Color color) {
        this.color = color;
    }

    public ColourSet next() {
        return ColourSet.values()[ (this.ordinal() + 1) % ColourSet.values().length];
    }

    public java.awt.Color getColor() {
        return color;
    }

    public static void main(String[] args) {
        ColourSet current = ColourSet.BLUE;
        for(;;) {
            System.out.println(current.getColor());
            current = current.next();
        }
    }
}