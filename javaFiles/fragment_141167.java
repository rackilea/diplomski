public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while (running) {
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while (delta >= 1) {
            tick();
            delta--;
        }
        if (running) {
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
}

private void tick() {

}

private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
        this.createBufferStrtegy(3);
        return;
    }
    Graphics g = bs.getDrawGraphics();
    g.dispose();
    bs.show();
}