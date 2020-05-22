@Override
public void start(Stage primaryStage) {
    Pane root = new Pane();
    root.setMinSize(500, 500);

    final double radius = 150;
    final double centerX = 250;
    final double centerY = 250;
    final double height = 40;

    Circle circle = new Circle(centerX, centerY, radius, null);
    circle.setStroke(Color.BLACK);

    // rect starts at the rightmost point of the circle touching it with the left midpoint
    Rectangle rect = new Rectangle(centerX + radius, centerY - height / 2, 10, height);
    rect.setFill(Color.RED);

    Rotate rotate = new Rotate(0, centerX, centerY); // pivot point matches center of circle

    rect.getTransforms().add(rotate);

    // animate one rotation per 5 sec 
    Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0d)),
            new KeyFrame(Duration.seconds(5), new KeyValue(rotate.angleProperty(), 360d)));
    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();

    root.getChildren().addAll(circle, rect);

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}