@SuppressWarnings("serial")
class Affich extends JPanel {
    private int width = 0;
    private int height = 0;

    public Affich(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(width, height);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // draw smooth oval
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawOval(0, 0, 50, 50);
    }
}