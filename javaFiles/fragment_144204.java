public enum Direction {
    NORTH (0, 1),
    SOUTH (0, -1),
    EAST (1, 0),
    WEST (-1, 0)

    private int xDirection, yDirection;

    Direction(int x, int y) {
        this.xDirection = x;
        this.yDirection = y;
    }

    public Vector2D getTranslation() {
        return new Vector2D(this.xDirection, this.yDirection);
    }
}