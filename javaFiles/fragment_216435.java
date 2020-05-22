@Override
public void start(Stage primaryStage) {
    Circle circle = new Circle(100, null);
    circle.setStrokeWidth(5);
    circle.setStroke(Color.BLACK);
    Effect effect = new DropShadow(BlurType.GAUSSIAN, Color.DODGERBLUE, 5, 0.75, 0, 0);

    Scene scene = new Scene(new StackPane(circle), 250, 250);
    scene.setOnMouseClicked(evt -> circle.setEffect(circle.getEffect() == null ? effect : null));
    primaryStage.setScene(scene);
    primaryStage.show();
}