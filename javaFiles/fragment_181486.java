@Override
public Dimension getPreferredScrollableViewportSize()
{
    return getPreferredSize();
}

@Override
public int getScrollableUnitIncrement(Rectangle visible, int orientation, int direction)
{
    return 1;
}

@Override
public int getScrollableBlockIncrement(Rectangle visible, int orientation, int direction)
{
    return 20;
}

@Override
public boolean getScrollableTracksViewportWidth()
{
    return true;
}

@Override
public boolean getScrollableTracksViewportHeight()
{
    return false;
}