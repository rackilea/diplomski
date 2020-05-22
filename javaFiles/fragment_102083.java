public class Node {

    private Point p;
    private int cost;
    private int estimatedCost;
    private Set<Point> points;
    private Point origin;

    public Node(Point p, int cost, Set<Point> points, Point origin) {
        this.p = p;
        this.points = points;
        this.origin = origin;
        this.cost = cost;
        // Heuristic estimate cost
        if (points.isEmpty()) {
            this.estimatedCost = cost + distance(p, origin);
            this.cost = estimatedCost;
        } else {
            this.estimatedCost = cost + nearest(p, points) + nearest(origin, points);
            for (Point point : points) {
                estimatedCost += nearest(point, points);
            }
        }
    }

    private static int distance(Point p0, Point p1) {
        return Math.abs(p0.x - p1.x) + Math.abs(p0.y - p1.y);
    }

    private int nearest(Point p, Set<Point> points) {
        int result = Integer.MAX_VALUE;
        for (Point point : points) {
            int d = distance(point, p);
            if (d != 0 && d < result) {
                result = d;
            }
        }
        return result;
    }

    public int getCost() {
        return cost;
    }


    public boolean isClosed(){
        return cost == estimatedCost;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public Node goTo(Point target) {
        int newCost = cost + distance(this.p, target);
        Set<Point> newPoints;
        if (points.isEmpty()) {
            newPoints = Collections.emptySet();
        } else {
            newPoints = new HashSet<>(points);
            newPoints.remove(target);
        }
        return new Node(target, newCost, newPoints, origin);
    }
}