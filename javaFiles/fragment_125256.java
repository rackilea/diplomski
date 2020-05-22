public static void main(String[] args) {
    Set<Point> points = new HashSet<>(8);
    points.add(new Point(0, 0));
    points.add(new Point(1, -1));
    points.add(new Point(1, 1));
    points.add(new Point(-1, -1));
    points.add(new Point(-1, -1));
    System.out.println("Set<Point> points:\n" + points);

    Compare<Point, Integer> sameX = (p, x) -> p.x == x;
    List<Point> matchingPoints =
            Utils.<Point, Integer>retrieve(points, 0, sameX);
    System.out.println("\nmatchingPoints:\n" + matchingPoints);
}