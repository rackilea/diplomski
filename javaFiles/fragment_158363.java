// you should be extending JFrame
public void addNotify() {
    super.addNotify();
    createBufferStrategy(2);
}

private synchronized void render() {
    BufferStrategy strategy = getBufferStrategy();
    if (strategy==null) return;
    sizeChanged = false;
    // Render single frame
    do {
        // The following loop ensures that the contents of the drawing buffer
        // are consistent in case the underlying surface was recreated
        do {
            MyGraphics draw = strategy.getDrawGraphics();
            draw.setColor(Color.BLACK);
            draw.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
            draw.drawImage(ship.getImage(), ship.getCurrentX(), ship.getCurrentY(), null);
            draw.dispose();

            // Repeat the rendering if the drawing buffer contents 
            // were restored
        } while (strategy.contentsRestored());

        // Display the buffer
        strategy.show();

        // Repeat the rendering if the drawing buffer was lost
    } while (strategy.contentsLost());
}