private static class CanvasPane extends Pane {

    final Canvas canvas;

    CanvasPane(double width, double height) {
        setWidth(width);
        setHeight(height);
        canvas = new Canvas(width, height);
        getChildren().add(canvas);

        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());
    }
}