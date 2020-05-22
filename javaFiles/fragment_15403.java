@SuppressWarnings("serial")
class PaintPanel extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;
    private static final int OVAL_WIDTH = 4;
    private static final Stroke BASIC_STROKE = new BasicStroke(OVAL_WIDTH);
    private BufferedImage img;
    private Color ovalColor;

    public PaintPanel() {
        img = new BufferedImage(PREF_W, PREF_W, BufferedImage.TYPE_INT_ARGB);
    }

    public void addLine(Point p1, Point p2) {
        if (img != null && ovalColor != null) {
            Graphics2D g2 = img.createGraphics();
            g2.setStroke(BASIC_STROKE);
            g2.setColor(ovalColor);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            g2.dispose();
            repaint();
        }
    }

    public void setOvalColor(Color ovalColor) {
        this.ovalColor = ovalColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
}