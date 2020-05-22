List<Point2D> points = new ArrayList<Point2D>();
Line2D line = new Line2D.Double(0, 0, 8, 4);
Point2D current;

for (Iterator<Point2D> it = new LineIterator(line); it.hasNext();) {
    current = it.next();
    points.add(current);
}

assertThat(points.toString(), 
    is("[Point2D.Double[0.0, 0.0], Point2D.Double[1.0, 0.0], " +
        "Point2D.Double[2.0, 1.0], Point2D.Double[3.0, 1.0], " +
        "Point2D.Double[4.0, 2.0], Point2D.Double[5.0, 2.0], " +
        "Point2D.Double[6.0, 3.0], Point2D.Double[7.0, 3.0], " +
        "Point2D.Double[8.0, 4.0]]"));