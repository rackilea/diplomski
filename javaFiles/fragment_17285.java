public enum Orientation {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int p;

    Orientation(int p) {
        this.p = p;
    }

    private static Orientation[] vals = new Orientation[4];
    static {
        for( Orientation o : Orientation.values() )
            vals[o.p] = o;
    }

    Orientation turnTo(Turn t) {
        return vals[(4 + this.p + (t == Turn.RIGHT ? 1 : -1)) % 4];
    }
}