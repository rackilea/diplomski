public interface Piece {
    public Rectangle getBounds();
    public Color getColor();
    public void setLocation(Point point);
    public void paint(Graphics2D g2d);
}