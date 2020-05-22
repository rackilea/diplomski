public void run() {
    while (true) {
        simulate();
        while (isPaused) {
            Thread.sleep(100);
        }
    }
}