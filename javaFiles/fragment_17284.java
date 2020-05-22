public enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    private static Orientation[] vals = values();

    Orientation turnTo(Turn t) {
        return vals[(4 + this.ordinal() + (t == Turn.RIGHT ? 1 : -1)) % 4];
    }
}