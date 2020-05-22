private StackPane root = new StackPane();
    private Scene scene = new Scene(root, 1366, 768);

    @Override
    public void start(Stage primaryStage) {
        Line line = new Line(0,100,100,100);
        line.setStrokeWidth(20);

        StackPane.setAlignment(line, Pos.CENTER);
        root.getChildren().add(line);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }