private class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
}

Point[][] pointSpecs = new Point[][] { {new Point( .5, .5) }, 
                                       {new Point(.25, .25), new Point(.75, .75)},
                                  ...};