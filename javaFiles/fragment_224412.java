private LinkedList<Point> getNextPositions(int x, int y){
    int[] xOffsets = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] yOffsets = {1, 2, 2, 1, -1, -2, -2, -1};
    Point nextPosition;
    LinkedList<Point>  = new LinkedList<Point>();
    for(int i = 0; i < xOffsets.length; i++) {
        nextPosition = new Point(x+xOffsets(i),y+yOffsets(i));
        if (isWithinBoardAndFree(nextPosition))
        {
            erg.add(nextPosition);
        }
    }
}