startButton.setOnMouseClicked(new EventHandler<Event>() {
    @Override
    public void handle(Event arg0) {
        for(int i=0; i<10; i++) {
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(i));
            int finalI = i;
            pauseTransition.setOnFinished(event -> rectangles[finalI].setFill(Color.RED));
            pauseTransition.play();
        }
    }
});