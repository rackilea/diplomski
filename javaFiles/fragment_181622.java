@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Get (100, 100) in here");
    Point2D pt = new Point2D(100, 100);

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), evt ->
            System.out.println(
                   btn.contains(btn.screenToLocal(pt))
            )
    ));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 200, 50);

    primaryStage.setScene(scene);
    primaryStage.show();
}