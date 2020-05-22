@Override
public void start(Stage primaryStage) {
    final Region r1 = new Region();
    r1.setStyle("-fx-background-color: yellow;");

    final Region r2 = new Region();
    r2.setStyle("-fx-background-color: blue;");

    final BorderPane root = new BorderPane(r1);

    Button btn = new Button("swap");
    btn.setOnAction(evt -> {
        root.setCenter(root.getCenter() == r1 ? r2 : r1);
    });

    root.setTop(btn);

    final Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}