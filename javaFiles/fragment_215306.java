private class Segment {
    private final List<Point> points = new ArrayList<Point>();
    private final Color color = initial;
    private final Stroke stroke = SimplePaint.this.stroke;
}

private final List<Segment> segments = new ArrayList<>();