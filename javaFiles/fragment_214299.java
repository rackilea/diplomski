public void run() {
    double ns = 1000000000.0 / 60.0;
    double delta = 0;

    long lastTime = System.nanoTime();

    while (running) {
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;

        while (delta >= 1) {
            tick();
            delta--;
        }
    }
}