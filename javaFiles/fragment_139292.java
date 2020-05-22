Timer timer = new Timer();
timer.schedule(
    new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> update(primaryStage));
            timer.cancel();
        }
    }, 400
);