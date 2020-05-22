private static class LineDrawListener implements EventHandler<ActionEvent> {

    private LineDrawListener(Canvas canvas, Pane canvasPane) {
        this.canvasPane = canvasPane;
        this.gc = canvas.getGraphicsContext2D();

        line = new Line();
        line.setStrokeWidth(10);
        line.setManaged(true);
        line.setMouseTransparent(true);

        releasedHandler = evt -> {
            // remove line from canvas parent and draw line on canvas instead
            canvasPane.getChildren().remove(line);
            Point2D start = canvas.parentToLocal(line.getStartX(), line.getStartY());
            Point2D end = canvas.parentToLocal(line.getEndX(), line.getEndY());
            gc.setLineWidth(10);
            gc.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
            removeListeners();
        };
        draggedHandler = evt -> {
            // update end of line
            line.setEndX(evt.getX());
            line.setEndY(evt.getY());
        };
        pressedHandler = evt -> {
            // add line to canvas parent
            canvasPane.getChildren().add(line);
            line.setStartX(evt.getX());
            line.setStartY(evt.getY());
            line.setEndX(evt.getX());
            line.setEndY(evt.getY());
        };
    }

    private final GraphicsContext gc;
    private final Pane canvasPane;
    private final Line line;

    private final EventHandler<MouseEvent> pressedHandler;

    private final EventHandler<MouseEvent> draggedHandler;

    private final EventHandler<MouseEvent> releasedHandler;

    private void removeListeners() {
        canvasPane.setOnMousePressed(null);
        canvasPane.setOnMouseDragged(null);
        canvasPane.setOnMouseReleased(null);
    }

    @Override
    public void handle(ActionEvent event) {
        canvasPane.setOnMousePressed(pressedHandler);
        canvasPane.setOnMouseDragged(draggedHandler);
        canvasPane.setOnMouseReleased(releasedHandler);
    }

}

@Override
public void start(Stage primaryStage) {
    Canvas canvas = new Canvas(400, 400);

    Rectangle clip = new Rectangle();
    clip.widthProperty().bind(canvas.widthProperty());
    clip.heightProperty().bind(canvas.heightProperty());

    Pane canvasPane = new Pane(canvas);
    canvasPane.setClip(clip);

    Button btn = new Button("Draw Line");
    LineDrawListener listener = new LineDrawListener(canvas, canvasPane);
    btn.setOnAction(listener);

    VBox root = new VBox(btn, canvasPane);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
}