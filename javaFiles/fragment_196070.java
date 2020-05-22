double startPos = ... ;
double endPos = ... ;
DoubleProperty y = new SimpleDoubleProperty(startPos);
Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(y, endPos)));
y.addListener((obs, oldValue, newValue) ->
    window.setY(newValue.doubleValue()));
timeline.play();