public class PointsPanel extends JPanel {
    List<Point> points = new ArrayList<Point>();
    int size = 10;
    ...
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point p : points) {
            int x = p.x - size/2;
            int y = p.y - size/2;
            g.drawOval(x, y, size, size);
        }
    }
}