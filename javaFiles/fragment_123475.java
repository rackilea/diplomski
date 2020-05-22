button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        pane.setVisible(false);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(1000), 
                        new KeyValue(pane.visibleProperty(), true)));
        timeline.play();
    }
});