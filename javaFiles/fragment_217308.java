public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // <-- HERE!
        g.drawOval(50, 50, 50, 50);
    }
}