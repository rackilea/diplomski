Point p1 = new Point(x, y);
Point p2 = new MyPoint(x, y);

p1.equals(p2) == false

Set<Point> points = new HashSet<>();
points.add(p1);

points.contains(p2) == false;