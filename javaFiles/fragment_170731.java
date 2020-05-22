node.setOnDragDetected(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        System.out.println("odDragDetected");

        double x = event.getX();
        double y = event.getY();
        dragVector = node.localToParent(x, y).subtract(node.getTranslateX(), node.getTranslateY());
        node.startFullDrag();
    }
});

node.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
    @Override
    public void handle(MouseDragEvent event) {
        System.out.println("onDragOver");

        Point2D parentCoords = node.localToParent(event.getX(), event.getY());

        node.setTranslateX(parentCoords.getX() -dragVector.getX());
        node.setTranslateY(parentCoords.getY() -dragVector.getY());
    }
});

node.setOnMouseReleased(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        dragVector = null;
    }
});