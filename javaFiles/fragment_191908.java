for (int i = 0; i < times && keepRunning.get(); i++) {
    checkPauseState();
    updateProgress(Math.round((i / (float) times) * 100f));
    try {
        Thread.sleep(1);
    } catch (InterruptedException ex) {
    }
}