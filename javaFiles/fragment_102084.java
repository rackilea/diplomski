public static void main(String[] args) {
    Point origin = new Point(1, 1);
    Set<Point> points = new HashSet<>(Arrays.asList(new Point(2, 3), new Point(5, 5), new Point(6, 5), new Point(9, 4)));
    Node begin = new Node(origin, 0, points, origin);
    PriorityQueue<Node> candidates = new PriorityQueue<>((n0, n1) -> Integer.compare(n0.estimatedCost, n1.estimatedCost));
    candidates.add(begin);
    Node solution = null;
    while (!candidates.isEmpty()) {
        Node candidate = candidates.poll();
        if (candidate.isClosed()) {
            solution = candidate;
            candidates.clear();
        } else {
            for (Point p : candidate.getPoints()) {
                candidates.add(candidate.goTo(p));
            }
        }
    }
    if (solution != null) {
        System.out.println(solution.getCost());
    }
}