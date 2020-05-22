Duration nextFrameTime = Duration.millis(10);
Timeline timeline = new Timeline();
for (Duration frameTimeIncrement = Duration.millis(10); 
     frameTimeIncrement.lessThan(Duration.seconds(1));
     frameTimeIncrement = frameTimeIncrement.add(Duration.millis(10))) {
    KeyFrame keyFrame = new KeyFrame(nextFrameTime, 
        e -> roll.setText(ThreadLocalRandom.current().nextInt(1, 66 + 1) + ""));
    timeline.getKeyFrames().add(keyFrame);
    nextFrameTime = nextFrameTime.add(frameTimeIncrement);
}
timeline.play();