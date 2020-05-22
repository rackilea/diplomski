public class CirclePanel extends JPanel {
    Circle circle = new Circle(100, 100);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        circle.drawCircle(g);
    }
}