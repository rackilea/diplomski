public class ColorPanel extends JPanel {
    private Color color;

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ...
        g.setColor(color);
    }
}