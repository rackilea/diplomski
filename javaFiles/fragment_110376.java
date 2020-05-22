private void pulsate(Node node) {

    node.setEffect(new DisplacementMap());

    ScaleTransition scaleUp = new ScaleTransition(
            Duration.millis(400), node
    );
    scaleUp.setFromX(1);
    scaleUp.setFromY(1);
    scaleUp.setToX(1.4);
    scaleUp.setToY(1.4);
    scaleUp.play();

    scaleUp.setOnFinished(su -> {
        ScaleTransition scaleDown = new ScaleTransition(
                Duration.millis(400), node
        );
        scaleDown.setFromX(1.4);
        scaleDown.setFromY(1.4);
        scaleDown.setToX(1);
        scaleDown.setToY(1);
        scaleDown.play();
        scaleDown.setOnFinished(sd -> node.setEffect(null));
    });
}