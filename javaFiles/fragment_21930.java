@Override
public void start(Stage primaryStage) {
    final Region r1 = new Region();
    r1.setStyle("-fx-background-color: yellow;");

    final Region r2 = new Region();
    r2.setStyle("-fx-background-color: blue;");

    final Scene scene = new Scene(r1);
    scene.setOnMouseClicked(evt -> {
        scene.setRoot(scene.getRoot() == r1 ? r2 : r1); // swap roots
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}