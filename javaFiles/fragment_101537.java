bgTask.messageProperty().addListener((observable, oldValue, newValue) -> {
    // currently:
    consoleTextArea.selectPositionCaret(consoleTextArea.getLength());
    consoleTextArea.deselect();

    // also tried:
    // consoleTextArea.setScrollTop(Double.MAX);
});