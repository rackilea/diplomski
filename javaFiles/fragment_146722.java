this.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent paramT) {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                if (isFocused() && !getText().isEmpty()) {
                    selectAll();
                }               
            }
        });
    }
});