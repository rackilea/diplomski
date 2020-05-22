@Override
protected void updateItem(Priority priority, boolean empty) {
    super.updateItem(priority, empty);
    ...
    setGraphic(rect);
    setStyle("-fx-padding: 0;");
    ...
}