@Override
public void start(Stage primaryStage) {
    final Region r1 = new Region();
    r1.setStyle("-fx-background-color: yellow;");
    VBox.setVgrow(r1, Priority.ALWAYS);

    final Region r2 = new Region();
    r2.setStyle("-fx-background-color: blue;");
    VBox.setVgrow(r2, Priority.ALWAYS);

    final VBox root = new VBox();

    Button btn = new Button("swap");
    btn.setOnAction(evt -> {
        root.getChildren().set(1, root.getChildren().get(1) == r1 ? r2 : r1);
    });

    root.getChildren().addAll(btn, r1);

    final Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}