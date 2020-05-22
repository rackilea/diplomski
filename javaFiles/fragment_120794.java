@Override
public void start(Stage primaryStage) {
    Slider slider = new Slider(0, 10, 5);
    slider.setMajorTickUnit(5);
    slider.setMinorTickCount(0);
    slider.setShowTickMarks(true);
    slider.setSnapToTicks(true);
    StackPane root = new StackPane(slider);
    root.getStyleClass().add("pane");
    Scene scene = new Scene(root, 300, 250);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}