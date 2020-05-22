KeyValue start = new KeyValue(enemy.translateXProperty(), 0);
KeyValue end = new KeyValue(enemy.translateXProperty(), 600);

KeyFrame startFrame = new KeyFrame(Duration.ZERO, start);
KeyFrame endFrame = new KeyFrame(Duration.seconds(5), end);

Timeline timeline = new Timeline(startFrame, endFrame);
timeline.setAutoReverse(true);
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();