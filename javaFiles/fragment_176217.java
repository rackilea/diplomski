public class HeartShape {

    private Shape shape;

    public HeartShape() {

    }

    public Shape Heart(double x, double y, double HEART_RADIUS) {
        double r = HEART_RADIUS;
        double root2 = Math.sqrt(2);
        double cx = x;
        double cy = y;
        double dx = r / root2;
        double heights = 3 * dx + r;
        double top = cy - heights / 2;
        double bottom = cy + heights / 2;

        Path2D base = new Path2D.Double();
        Shape s = new Arc2D.Double(cx - dx - r, top, 2 * r, 2 * r, 45, 180, Arc2D.OPEN);
        base.append(s, false);
        s = new Line2D.Double(cx, bottom, cx - 2 * dx, bottom - 2 * dx);
        base.append(s, true);
        s = new Line2D.Double(cx, bottom, cx + 2 * dx, bottom - 2 * dx);
        base.append(s, true);
        s = new Arc2D.Double(cx + dx - r, top, 2 * r, 2 * r, -45, 180, Arc2D.OPEN);
        base.append(s, true);

        base.closePath();

        shape = base;

        return base;
    }

    public void drawHeart(Graphics2D g2d, boolean isFilled) {
        System.out.println("...");
        if (isFilled) {
            g2d.fill(shape);
        } else {
            g2d.draw(shape);
        }
    }
}