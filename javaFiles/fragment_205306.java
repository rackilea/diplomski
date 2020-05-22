public void run() {
    while (gameRunning) {
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.GREEN);
        int width = getWidth() - 50;
        int height = getHeight() - 50;
        graphics.fillRect(25, 25, width, height);
        graphics.setColor(Color.BLACK);
        FontMetrics fm = graphics.getFontMetrics();
        graphics.drawString("Frame Size: " + frame.getWidth() + "x" + frame.getHeight(), 0, fm.getAscent());
        graphics.drawString("Canvas Size: " + getWidth() + "x" + getHeight(), 0, fm.getAscent() + fm.getHeight());

        graphics.dispose();
        bufferStrategy.show();
        try {
            Thread.sleep(60);
        } catch (InterruptedException ex) {
        }
    }
}