public class OvalIcon implements Icon {
    private int width;
    private int height;
    private Color color;

    public OvalIcon(int w, int h, Color color) {
        if((w | h) < 0) {
            throw new IllegalArgumentException("Illegal dimensions: "
                    + "(" + w + ", " + h + ")");
        }
        this.width  = w;
        this.height = h;
        this.color  = (color == null) ? Color.BLACK : color;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color temp = g.getColor();
        g.setColor(color);
        g.fillOval(x, y, getIconWidth(), getIconHeight());
        g.setColor(temp);
    }
    @Override
    public int getIconWidth() {
        return width;
    }
    @Override
    public int getIconHeight() {
        return height;
    }
}