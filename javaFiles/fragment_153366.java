@Override
public void start(Stage primaryStage) {
    Circle circle = new Circle(300, 20, 5);
    Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(circle.centerYProperty(), circle.getCenterY())),
            new KeyFrame(Duration.seconds(1), new KeyValue(circle.centerYProperty(), 300))
    );
    animation.setCycleCount(Animation.INDEFINITE);
    animation.setAutoReverse(true);

    Button btn = new Button("Play");
    btn.pressedProperty().addListener((observable, wasPressed, pressed) -> {
        System.out.println("changed");
        if (pressed) {
            animation.play();
        } else {
            animation.pause();
        }
    });

    Pane root = new Pane(btn, circle);

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}