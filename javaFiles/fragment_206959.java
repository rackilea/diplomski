@FXML
private Pane container;

@FXML
public void createEntity() {
    class DraggedHandler implements EventHandler<MouseEvent> {

        double offsetX;
        double offsetY;

        @Override
        public void handle(MouseEvent event) {
            Node source = (Node) event.getSource();
            Point2D pt = source.localToParent(event.getX(), event.getY());
            source.setLayoutX(pt.getX() + offsetX);
            source.setLayoutY(pt.getY() + offsetY);
        }

    }

    Rectangle rect = new Rectangle(i, i, 50, 20);
    i += 30;
    container.getChildren().add(rect);

    rect.addEventHandler(MouseEvent.ANY, event -> {
        if (event.getButton() != MouseButton.MIDDLE) {
            event.consume();
        }
    });

    DraggedHandler handler = new DraggedHandler();
    rect.setOnMouseDragged(handler);
    rect.setOnMousePressed(evt -> {
        Node source = (Node) evt.getSource();
        Point2D pt = source.localToParent(evt.getX(), evt.getY());
        handler.offsetX = source.getLayoutX() - pt.getX();
        handler.offsetY = source.getLayoutY() - pt.getY();
    });
}