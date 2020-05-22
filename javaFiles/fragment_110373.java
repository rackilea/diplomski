private void fadeIn(Node node) {
    FadeTransition fadeTransition = new FadeTransition(
            Duration.millis(900), 
            node
    );
    fadeTransition.setFromValue(0);
    fadeTransition.setToValue(1);
    fadeTransition.play();
}