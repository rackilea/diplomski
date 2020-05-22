public UI () {

    // set up ui, etc...

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e-> {
        if (! operationQueue.isEmpty()) {
            operationQueue.remove().run();
        }
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
}