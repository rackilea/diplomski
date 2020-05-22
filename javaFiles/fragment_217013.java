public class Blue_Box extends JPanel {

    private static final int PREF_W = 640;
    private static final int PREF_H = 480;
    private Point p1 = new Point(100, 100);
    private Point p2 = new Point(540, 380);

    public Blue_Box() {

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.draw(new Rectangle2D.Double(p1.x, p1.y, 40, 30));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

}