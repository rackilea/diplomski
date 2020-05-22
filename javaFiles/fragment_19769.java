public class ShapeContainer extends JPanel {
    private List<Shape> shapes;

    public ShapeContainer() {
        shapes = new ArrayList<>(25);
    }

    public void add(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            Graphics2D g2d = (Graphics2D) g.create();
            shape.paint(g2d);
            g2d.dispose();
        }
    }



}