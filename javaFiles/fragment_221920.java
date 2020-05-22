final ProgressBar bar = new ProgressBar();
new Thread(new Runnable() {
    @Override public void run() {
    for (int i = 1; i <= 1000000; i++) {
        final int counter = i;
        Platform.runLater(new Runnable() {
            @Override public void run() {
                bar.setProgress(counter / 1000000.0);
            }
        });
    }
}).start();