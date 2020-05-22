public class CrossedLabel extends JLabel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 100, 100);
    }
}