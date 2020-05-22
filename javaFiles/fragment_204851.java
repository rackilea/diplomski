public int obtainFontDimension(Graphics2D g2d)
{
    if(font == null){ font = Fonts.DEFAULT; }
    g2d.setFont(font);

    FontMetrics fm = g2d.getFontMetrics(font);
    Rectangle2D sb = fm.getStringBounds(text, g2d);
    this.width = (int)sb.getWidth();
    this.height = (int)sb.getHeight();
    this.descent = (int)fm.getDescent(); // added
    tempShape = new Rectangle(width, height+descent); // Temp for drawing bounds

    return height;
}