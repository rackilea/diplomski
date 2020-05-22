primaryStage.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
    if (primaryStage.isFullScreen() && event.isShortcutDown() && event.isPrimaryButtonDown()) {
        primaryStage.setFullScreen(false);
        event.consume();
    }
});