AnimationTimer updateTimer = new AnimationTimer() {

    @Override
    public void handle(long timestamp) {
        Runnable update = updateQueue.poll();
        if (update != null) {
            // note we are already on the FX Application Thread:
            update.run();
        }
    }
};

updateTimer.start();