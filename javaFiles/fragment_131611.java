mainAnchor.setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.DEAD_TILDE) {
        previewCard.setOpacity(previewCard.getOpacity() == 0.0 ? 1.0 : 0.0);
        event.consume();
    }
});