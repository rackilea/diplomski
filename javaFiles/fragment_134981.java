public enum Direction {
    DIAGONAL_RIGHT_UP(1,1),
    DIAGONAL_RIGHT_DOWN(1,-1),
    DIAGONAL_LEFT_UP(-1,1),
    DIAGONAL_LEFT_DOWN(-1,-1);

    public int x;
    public int y;

    private Direction(int xCoordinateChange,int yCoordinateChange) {
         x=xCoordinateChange;
         y=yCoordinateChange;
    }
}