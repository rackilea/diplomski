public Component getComponentAtPoint(Point p)
{
    int translatedX = p.x + scrollOffset;

    if (isWrap())
    {
        int preferredWidth = super.getPreferredSize().width;
        preferredWidth += getWrapAmount();
        translatedX = translatedX % preferredWidth;
    }

    Point translated = new Point(translatedX, p.y);

    for (Component c: getComponents())
    {
        if (c.getBounds().contains(translated))
            return c;
    }

    return null;
}