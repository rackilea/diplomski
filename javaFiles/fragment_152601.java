public class Screen extends JComponent {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); //sprites overlap instead of overwrite
        if (game == null) {
            drawSplash(g2D);
        } else {
            drawBoard(g2D);
        }
        g2D.dispose();
    }
}