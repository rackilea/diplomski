public class DrawShape {

    public final String text;
    public final Color color;
    public final Shape shape;

    public DrawShape(String text, Color color, Shape shape) {
        this.text = text;
        this.color = color;
        this.shape = shape;
    }
}

public class CanvasWithShapes extends JPanel {

    private List<DrawShape> shapes = new ArrayList<>();

    public void addShape(DrawShape shape) {
        shapes.add(shape);
    }

    @Override
    public void paintComponent(Graphics g) {
        final Graphics2D gg = (Graphics2D) g;
        // Java 8: shapes.stream().forEach((shape) -> gg.draw(shape));
        for (DrawShape drawShape : shapes) {
            gg.setColor(drawShape.color);
            gg.draw(drawShape.shape);
            Rectangle bounds = shape.getBounds();
            gg.drawString(shape.text, bounds.x+ 10, bounds.y + 20);
        }
    }
}