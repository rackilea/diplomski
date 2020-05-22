private void restartStopwatch(Button button) {
    Timeline timeline = new Timeline();
    for (int i = 0; i <= 5; i++) {
        final int timeRemaining = 5 - i ;
        KeyFrame frame = new KeyFrame(Duration.seconds(i), 
            e -> button.setText("Updated. Restarting in: " + timeRemaining + " Seconds..."));
        timeline.getKeyFrames().add(frame);
    }
    timeline.setOnFinished(e -> new UpdateChecker().restartApplication());
    timeline.play();
}