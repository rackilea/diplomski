class Critter {
    // constants for directions
    public static enum Direction {
        NORTH, SOUTH, EAST, WEST, CENTER
    };
}

class Foo {
    public void x() {
        Critter.Direction d = Critter.Direction.CENTER;
    }
}