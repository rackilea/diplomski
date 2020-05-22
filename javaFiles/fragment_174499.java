class DoubleBufferedCanvas extends Canvas {

    public void update(Graphics g) {
    Graphics offgc;
    Image offscreen = null;
    Dimension d = size();

    // create the offscreen buffer and associated Graphics
    offscreen = createImage(d.width, d.height);
    offgc = offscreen.getGraphics();
    // clear the exposed area
    offgc.setColor(getBackground());
    offgc.fillRect(0, 0, d.width, d.height);
    offgc.setColor(getForeground());
    // do normal redraw
    paint(offgc);
    // transfer offscreen to window
    g.drawImage(offscreen, 0, 0, this);
    }
}