public void moveBalls()
{
    if (! this.isRunning)
    {
        return;
    }
    for (final Ball b : balls)
    {
        // Remember, `move` no longer calls `paint`...  It just
        // updates some numbers.
        b.move();
    }
    // Now that the visible state has changed, ask Swing to
    // schedule repainting the panel.
    repaint();
}