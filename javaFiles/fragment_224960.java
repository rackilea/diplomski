public void start(Stage primaryStage) {
    try {
        BorderPane root = new BorderPane();
        root.setSnapToPixel(true);
        Scene scene = new Scene(root, 400, 400);

        Line line = new Line();
        Line line2 = new Line();

        line.setStartX(0.5);
        line.setEndX(100.5);
        line.setStartY(30.5);
        line.setEndY(30.5);
        line.setStrokeWidth(1.0);
        line.setStrokeType(StrokeType.CENTERED);
        line.setStroke(Color.BLACK);

        line2.setStartX(50.5);
        line2.setEndX(200.5);
        line2.setStartY(100.5);
        line2.setEndY(100.5);
        line2.setStrokeWidth(1.0);
        line2.setStrokeType(StrokeType.CENTERED);
        line2.setStroke(Color.BLACK);

        root.getChildren().addAll(line, line2);

        primaryStage.setScene(scene);
        primaryStage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}