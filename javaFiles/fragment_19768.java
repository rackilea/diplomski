public class OvalShape extends AbstractShape {

    public OvalShape(Rectangle bounds, boolean filled, Color color) {
        super(bounds, filled, color);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(this.getColor());
        Rectangle bounds = getBounds();
        if (isFilled()) {
            g2d.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        } else {
            g2d.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

}