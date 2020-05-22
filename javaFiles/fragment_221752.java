public int getPosition(int x, int y) {
    return ((y - 1) * 9) + (x + 4);
}

public Point getCoordinates(int position) {
    //calculate x and y
    int y = (int) ((position / 9) + 1);
    int x = (position - ((y - 1) * 9)) - 4;

    Point point = new Point(x, y);
    return point;
}