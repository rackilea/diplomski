class Point {
    final int x;
    final int y;

    public Point(int x, int y) {
        this.x= x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;   //If objects equal, is OK
        if (o instanceof Point) {
           Point that = (Point)o;
           return (x == that.x)  && y == that.y);
        }
        return false;
    }
}

class ColoredPoint extends Point {
   final Color color;
   ColoredPoint(int x, int y, Color color) {
      super(x, y);
      this.color = color
   }
}

Point p1 = new Point(1, 2);
ColoredPoint cp1 = new ColoredPoint(1, 2, Color.BLUE);
ColoredPoint cp1 = new ColoredPoint(1, 2, Color.RED);