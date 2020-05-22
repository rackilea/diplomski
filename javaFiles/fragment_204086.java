public void start(Stage primaryStage) {
    Group mainGroup = new Group();
    Rectangle r = new Rectangle(0, 0, 200, 200);

    Stop[] stops = new Stop[] { new Stop(0, new Color(0.0, 0.0, 1.0, 1.0)), 
                                new Stop(1, new Color(1.0, 1.0, 1.0, 0.0)) };
    LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
    r.setFill(lg);

    mainGroup.getChildren().add(r);
    Scene scene = new Scene(mainGroup, 200, 200);
    scene.setFill(Color.TRANSPARENT);
    primaryStage.setScene(scene);
    primaryStage.show();

    WritableImage image = scene.snapshot(null);
    PixelReader pixelReader = image.getPixelReader();

    System.out.println("Color: " + pixelReader.getColor((int)image.getWidth()/2, (int)image.getHeight()/2));
}