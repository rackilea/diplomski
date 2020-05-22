mainAnchor.setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.DEAD_TILDE) {
        previewCard.setVisible(!previewCard.isVisible());
        event.consume();
    }
});