public class ImagePanel extends JPanel {
    private final int D_W = 400;
    private final int D_W = 400;
    private BufferedIMage imag;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }
}