public BufferedImage buffer;

public void redraw() {
    buffer = new BufferedImage(
            200, // height
            300, // width
            BufferedImage.TYPE_4BYTE_ABGR); // ABGR = RGBA, 4-byte (r, g, b, a) per pixel
    Graphics g = buffer.getGraphics();
    // do your drawing here
    if (this.getGraphics()) {
        // 'this' is already shown, so it needs a redraw
        this.paint(this.getGraphics()); // little hack
    }
}

public void update(Graphics g) {
    this.paint(g);
}

public void paint(Graphics g) {
    g.drawImage(buffer, 0, 0, this);
}