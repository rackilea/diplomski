private final Rectangle rect = new Rectangle();

@Override
protected void updateItem(Priority priority, boolean empty) {
    super.updateItem(priority, empty);
    if(priority == null || empty) {
      setGraphic(null);
      return;
    }
    setGraphic(rect);
    setStyle("-fx-padding: 0;");
    rect.widthProperty().bind(widthProperty().subtract(2));
    rect.heightProperty().bind(heightProperty().subtract(2));
    ...
}