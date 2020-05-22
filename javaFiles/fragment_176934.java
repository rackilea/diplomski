void updateValue(T value) {
    setNewValue(value);
    if (lastUpdateFinished()) {
        Platform.runLater(() -> doUpdate());
    }
}