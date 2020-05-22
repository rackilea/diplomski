public enum Edge {
    TOP, BOTTOM, LEFT, RIGHT;
    private Edge opposite;

    static {
        TOP.opposite = BOTTOM;
        BOTTOM.opposite = TOP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
    }
    public Edge opposite(){
        return this.opposite;
    }
}