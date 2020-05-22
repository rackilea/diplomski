public void draw(Graphics2D g2d)
{
    g2d.setFont(font);
    g2d.setColor(color);
    g2d.drawString(text, dx, dy);

    // Drawing bounds for testing
    g2d.setColor(new Color(0, 0, 0, 100));
    shape.setLocation(dx, dy-height);
    g2d.draw(tempShape);
}