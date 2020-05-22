private void setupSelectionDragHack()
{
    // Bracket the other mouse listeners so we may inject our lie
    final MouseListener[] ls = getMouseListeners();
    for (final MouseListener l : ls)
    {
        removeMouseListener(l);
    }
    addMouseListener(new MouseAdapter()
    {
        @Override
        public void mousePressed(final MouseEvent e)
        {
            // NOTE: it might not be necessary to check the row, but... I figure it's safer maybe?
            mousingRow = rowAtPoint(e.getPoint());
            mousingInProgress = true;
        }
    });
    for (final MouseListener l : ls)
    {
        addMouseListener(l);
    }
    addMouseListener(new MouseAdapter()
    {
        @Override
        public void mousePressed(final MouseEvent e)
        {
            mousingInProgress = false;
        }
    });
}