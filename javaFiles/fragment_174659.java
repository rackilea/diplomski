public void scrollVAnimate(ScrollPane scrollPane, double duration, double toVal)
{
    TimelineBuilder.create()
        .keyFrames(
            new KeyFrame(
                Duration.millis(duration),
                new KeyValue(scrollPane.vvalueProperty(), toVal)
            )).build()
            .play();
}