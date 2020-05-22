private void slideDown(Node node) {
    TranslateTransition slideDown = new TranslateTransition(
            Duration.millis(900), 
            node
    );
    slideDown.setFromY(-400);
    slideDown.setToY(0);
    slideDown.play();
}