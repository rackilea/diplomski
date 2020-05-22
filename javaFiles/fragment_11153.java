public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = -4603711384104715819L;

    private int x;
    private int y;

    private BufferedImage image;

    public DrawingPanel(BufferedImage image) {
        this.image = image;
        this.x = 0;
        this.y = 0;
        setPreferredSize(new Dimension(500, 500));
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, null);
    }

}