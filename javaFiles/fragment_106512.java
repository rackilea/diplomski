protected void paintComponent(Graphics g) {
    super.paintComponent(g); // <-- Insert me here and watch problem go away
    RandomX();
    RandomY();

    g.setColor(RandomColour());
    g.fillRect(x, y, xSize, ySize);
    try {
        Thread.sleep(50); // <-- This is an INCREDIBLY bad idea, NEVER, EVER do this

    } catch (InterruptedException e) {  
    }

    repaint(); // <-- This is a bad idea, watch CPU max out...
}