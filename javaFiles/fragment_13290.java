private void selectTextIfFocused(ComboBox box){
    Platform.runLater(() -> {
        if ((box.getEditor().isFocused() || box.isFocused()) && !box.getEditor().getText().isEmpty()) {
            box.getEditor().selectAll();
        }
    });
}