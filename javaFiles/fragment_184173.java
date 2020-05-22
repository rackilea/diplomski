public void restart() {
    // May return null and is only a snapshot of what's current within the components
    // graphics buffer...
    Graphics g = getGraphics();
    Dimension d = getSize();
    Color c = getBackground();

    g.setColor(c);
    g.fillRect(0,0,d.width,d.height);

    // Every thing you just did will not be discard as when paintComponent
    // is called...
    repaint();
}