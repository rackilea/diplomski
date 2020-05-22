for (/* rows */) {
  Point pt1 = new Point(x1, y1); // Extract from the table.
  Point pt2 = new Point(x2, y2); // Extract from the table.
  Set<Point> adjs = adjacencies.find(pt1);
  if (adjs == null) {
    adjs = new HashSet<Point>();
    adjacencies.put(pt1, adjs);
  }
  adjs.put(pt2);
  // Same for pt2
}