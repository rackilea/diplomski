double orgSceneX, orgSceneY;
double orgTranslateX, orgTranslateY;
EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent t) {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        Node source = (Node) t.getSource();
        orgTranslateX = source.getTranslateX();
        orgTranslateY = source.getTranslateY();
    }
};

EventHandler<MouseEvent> circleOnMouseDraggedEventHandler
        = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                Node source = (Node) t.getSource();

                Bounds sceneBounds = source.getScene().getRoot().getLayoutBounds();
                Bounds localBounds = source.getBoundsInLocal();

                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;

                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                // restirct x movement to scene bounds
                if (offsetX >= 0) {
                    if (localBounds.getMaxX() + newTranslateX > sceneBounds.getMaxX()) {
                        newTranslateX = sceneBounds.getMaxX() - localBounds.getMaxX();
                    }
                } else {
                    if (localBounds.getMinX() + newTranslateX < 0) {
                        newTranslateX = -localBounds.getMinX();
                    }
                }

                // restrict y movement to scene bounds
                if (offsetY >= 0) {
                    if (localBounds.getMaxY() + newTranslateY > sceneBounds.getMaxY()) {
                        newTranslateY = sceneBounds.getMaxY() - localBounds.getMaxY();
                    }
                } else {
                    if (localBounds.getMinY() + newTranslateY < 0) {
                        newTranslateY = -localBounds.getMinY();
                    }
                }

                source.setTranslateX(newTranslateX);
                source.setTranslateY(newTranslateY);
            }
        };

@Override
public void start(Stage primaryStage) {
    Circle circle = new Circle(100, 100, 50);
    circle.setOnMousePressed(circleOnMousePressedEventHandler);
    circle.setOnMouseDragged(circleOnMouseDraggedEventHandler);

    Pane root = new Pane(circle);

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}