public class Element {

    private Point position = new Point();
    private float orientation;

    private AffineTransform transform = new AffineTransform();
    private Shape shape = new Rectangle(0, 0, 100, 100);
    private Area boundingBox;

    public void onMouseDrag(MouseEvent e) {
        translate(dx, dy);
    }

    public void onMouseMove(MouseEvent e) {
        rotate(Math.atan2(dx / dy));
    }

    public void translate(int dx, int dy) {
        position.translate(dx, dy);
        updateTransform();
    }

    public void rotate(double angle) {
        orientation += Math.toRadians(angle);
        updateTransform();
    }

    private void updateTransform() {
        transform.setToIdentity();
        transform.translate(position.x, position.y);
        transform.rotate(orientation);
        // ... update bounding box here ...
    }

    public void draw(Graphics2D g2d) {
        g2d.setTransform(transform);
        g2d.draw(shape);
    }

}