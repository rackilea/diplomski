AtomicReference<Image> latestImage = new AtomicReference<>();

TimerTask frameGrabber = new TimerTask() {
    @Override
    public void run() {
        if (latestImage.setAndGet(processVideo()) == null) {
            Platform.runLater(() -> imageView.setImage(latestImage.setAndGet(null)));
        }
    }
};

// rate at which you want to sample video:
double sampleRate = ... ;
long sampleMillis = (long) 1000 / sampleRate ;
this.timer.schedule(frameGrabber, 0, sampleMillis);