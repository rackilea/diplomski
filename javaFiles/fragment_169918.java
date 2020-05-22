sp.setOnMouseClicked(event -> {

    Timeline timeline = new Timeline();
    int step = 250 ;
    int millis = 0 ;
    for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(millis), e -> {
            labelUp.setText(entry.getKey());
            labelDw.setText(entry.getValue().toString());
        }));
        millis += step ;
    }
    timeline.play();
});