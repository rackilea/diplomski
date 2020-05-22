public void run() {
    init();
    final long amountOfTicks = 60;
    long ns = Math.round(1_000_000_000 / (double)amountOfTicks);

    int frames = 0;
    long frameStart = System.currentTimeMillis();

    while (running) {
        long startedAt = System.nanoTime();
        tick();
        render();
        long completedAt = System.nanoTime();
        long duration = completedAt - startedAt;

        long frameEnd = System.currentTimeMillis();
        if (frameEnd - frameStart >= 1000) {
            System.out.println(frames);
            frames = 0;
            frameStart = System.currentTimeMillis();
        } else {
            frames++;
        }

        long rest = ns - duration;
        if (rest > 0) {
            rest = TimeUnit.MILLISECONDS.convert(rest, TimeUnit.NANOSECONDS);
            try {
                Thread.sleep(rest);
            } catch (InterruptedException ex) {
            }
        }
    }
    stop();
}