public class RainbowBorder extends AbstractBorder {

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.bottom = insets.top = insets.left = insets.right = 1;
        return insets;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        LinearGradientPaint lpg = new LinearGradientPaint(
            new Point(x, y),
            new Point(x, y + height),
            new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f},
            new Color[]{Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA});
        g2d.setPaint(lpg);
        g2d.draw(new Rectangle2D.Double(x, y, width - 1, height - 1));
        g2d.dispose();
    }

}