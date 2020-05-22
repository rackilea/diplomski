@Override
public void start(Stage primaryStage) {
    Line line = new Line(25, 125, 125, 125);
    Rotate rotate = new Rotate(0, 125, 125);
    line.getTransforms().add(rotate);

    ToggleButton btn = new ToggleButton();
    btn.textProperty().bind(Bindings.when(btn.selectedProperty()).then("5 Hz").otherwise("2 Hz"));
    StackPane.setAlignment(btn, Pos.BOTTOM_LEFT);

    // rotate by one 60th of a full rotation each time
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> rotate.setAngle((rotate.getAngle() + (360d / 60d)) % 360)));
    timeline.setCycleCount(Animation.INDEFINITE);

    // rate depends on button state
    timeline.rateProperty().bind(Bindings.when(btn.selectedProperty()).then(5d).otherwise(2d));

    Pane linePane = new Pane(line);
    linePane.setMinSize(250, 250);
    linePane.setMaxSize(250, 250);
    StackPane root = new StackPane();
    root.getChildren().addAll(linePane, btn);

    Scene scene = new Scene(root, 300, 300);

    primaryStage.setScene(scene);
    timeline.play();

    primaryStage.show();
}