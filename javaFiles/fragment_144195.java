public void start(Stage primaryStage) throws Exception {
    Pane root = new Pane();
    Canvas canvas = new Canvas();
    canvas.setHeight(400);
    canvas.setWidth(400);

    GraphicsContext graphics = canvas.getGraphicsContext2D();
    //graphics.save();
    graphics.beginPath();
    graphics.rect(0,0,200,200);
    graphics.clip();
    graphics.setFill(Color.RED);
    graphics.fillOval(100, 100, 200, 200);

    //graphics.restore();
    graphics.beginPath();
    graphics.rect(200,200,200,200);
    graphics.clip();

    graphics.setFill(Color.BLUE);
    graphics.fillOval(100, 100, 200, 200);

    root.getChildren().add(canvas);
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}