final Timeline timeline = new Timeline();
    timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.millis(0)),
        new KeyFrame(Duration.millis(3000),
            event -> {
                line1.endXProperty().bind(c3.centerXProperty());
                line1.endYProperty().bind(c3.centerYProperty());
            },
            new KeyValue(c2.centerYProperty(), 200), 
            new KeyValue(c2.centerXProperty(), 50), 
            new KeyValue(c3.centerYProperty(), 100), 
            new KeyValue(c3.centerXProperty(), 100)),
        new KeyFrame(Duration.millis(6000),
            new KeyValue(c3.centerXProperty(), 200), 
            new KeyValue(c3.centerYProperty(), 50), 
            new KeyValue(c1.centerXProperty(), 250), 
            new KeyValue(c1.centerYProperty(), 100), 
            new KeyValue(c2.centerXProperty(), 100), 
            new KeyValue(c2.centerYProperty(), 100)));