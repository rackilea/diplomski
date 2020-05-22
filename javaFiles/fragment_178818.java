@Override
public void start(Stage primaryStage) throws Exception {
    Pane root = new Pane();
    root.setPrefSize(600, 800);
    Canvas canvas = new Canvas();

    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image original = new Image(getClass().getResourceAsStream(path));

    root.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
        canvas.setWidth(newValue.getWidth());
        canvas.setHeight(newValue.getHeight());
        gc.drawImage(original, 0, 0);
    });

    root.getChildren().add(canvas);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}