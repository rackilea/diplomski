private KeyCode key;

private final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), evt -> {
    switch (key) {
        case RIGHT:
            drawNextPosition();
        break;
        case LEFT:
            drawPreviousPosition();
        break;
    }
});

private void keyDown(KeyCode code) {
    switch (code) {
        case LEFT:
        case RIGHT:
            // start timeline or continue playing
            timeline.play();
            key = code;
    }

}

private void keyUp(KeyCode code) {
    if (code == key) {
        // stop animation, if key for current direction is released
        timeline.stop();
        key = null;
    }
}