public class Kulka {

    private PaintContainer container;
    private float angle;
    private float delta;

    public Kulka(PaintContainer container, float angle, float delta) {
        this.container = container;
        this.angle = angle;
        this.delta = delta;
    }

    public void update() {
        angle += delta;
        container.wasUpdated(this);
    }

    public void paint(Graphics2D g2d) {
        int diameter = Math.min(container.getWidth(), container.getHeight());
        float innerDiameter = 20;

        Point point = getPointOnCircle(angle, (diameter / 2f) - (innerDiameter / 2));
        g2d.setColor(Color.RED);
        g2d.fill(new Ellipse2D.Double(point.x, point.y, innerDiameter, innerDiameter));
    }

    public Point getPointOnCircle(float degress, float radius) {

        int x = Math.round(container.getWidth() / 2);
        int y = Math.round(container.getHeight() / 2);

        double rads = Math.toRadians(degress - 90);

        int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
        int yPosy = Math.round((float) (y + Math.sin(rads) * radius));

        return new Point(xPosy, yPosy);

    }

}