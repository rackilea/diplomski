public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;

    for (Segment segment : segments) {
        g2.setColor(segment.color);
        g2.setStroke(segment.stroke);
        for (int p = 0; p < segment.points.size() - 1; p++) {
            Point p1 = segment.points.get(p);
            Point p2 = segment.points.get(p + 1);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    g2.dispose();
}