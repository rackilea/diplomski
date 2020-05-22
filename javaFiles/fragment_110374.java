private void fadeOut(Node node) {
    FadeTransition fadeTransition = new FadeTransition(
            Duration.millis(900), 
            node
    );
    fadeTransition.setFromValue(1);
    fadeTransition.setToValue(0);
    fadeTransition.play();
}