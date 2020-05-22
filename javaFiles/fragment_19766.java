public interface Shape {
    public Rectangle getBounds();
    public boolean isFilled();
    public Color getColor();
    public void paint(Graphics2D g2d);
}