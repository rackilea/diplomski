Task task = new Task<Void>() {
    @Override public Void run() {
        static final int max = 1000000;
        for (int i=1; i<=max; i++) {
            updateProgress(i, max);
        }
        return null;
    }
};
ProgressBar bar = new ProgressBar();
bar.progressProperty().bind(task.progressProperty());
new Thread(task).start();