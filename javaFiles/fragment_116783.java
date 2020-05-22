private void repeatFocus(Node node) {
    Platform.runLater(() -> {
        if (!node.isFocused()) {
            node.requestFocus();
            repeatFocus(node);
        }
    });
}