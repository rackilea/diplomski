public void handle(MouseEvent mouseEvent) {
    Rectangle rect = new Rectangle();
    rect.setWidth(RECTANGLE_DEFAULT_WIDTH);
    rect.setHeight(RECTANGLE_DEFAULT_HEIGHT);
    rect.setFill(null);
    rect.setStroke(Color.BLACK);
    Text text = new Text("mockText");
    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(rect, text);
    stackPane.setLayoutX(mouseEvent.getX());
    stackPane.setLayoutY(mouseEvent.getY());
    root.getChildren().add(stackPane);
}