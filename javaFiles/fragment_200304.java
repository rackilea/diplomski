while (true) {
    try {
        Thread.sleep(10); // for 100 FPS
    } catch (InterruptedException ignore) {
    }
    updatePos(x, y);
}