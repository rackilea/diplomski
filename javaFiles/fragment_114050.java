public static class FloatCircle {

    Node node;

    Circle rectangle;
    Pane root;

    public FloatCircle(Node node, Pane root) {
        this.node = node;
        this.root = root;
        this.rectangle = new Circle();
        this.rectangle.setManaged(false);

        initSetting();

    }

    public Circle getFloatCircle() {
        return rectangle;
    }

    public void initSetting() {

        ChangeListener<Object> updater = (obs, oldValue, newValue) -> 
            setLocation(node.localToScene(node.getBoundsInLocal()));
        node.boundsInLocalProperty().addListener(updater);
        node.localToSceneTransformProperty().addListener(updater);

        setLocation(node.localToScene(node.getBoundsInLocal()));
        addCircle();
    }

    public void setLocation(Bounds localToScreen) {
        int r = 10;
        rectangle.setCenterX(localToScreen.getMinX() - r);
        rectangle.setCenterY(localToScreen.getMinY() - 5);
        rectangle.setRadius(r);
    }

    public void addCircle() {
        root.getChildren().add(rectangle);

    }

}