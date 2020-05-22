final KeyCombination openDir = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);

EventHandler<KeyEvent> eventHandler = event -> {
    if (openDir.match(event)) {
        logger.debug("Event match.");
    }
};

list.sceneProperty().addListener((observable, oldValue, newValue) -> {
    if (oldValue != null) {
        oldValue.removeEventFilter(KEY_PRESSED, eventHandler);
    }

    if (newValue != null) {
        newValue.addEventFilter(KEY_PRESSED, eventHandler);
    }
});