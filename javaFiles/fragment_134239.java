@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello World!");


    StackPane root = new StackPane();
    root.getChildren().add(agenda);
    primaryStage.setScene(new Scene(root, 600, 600));
    primaryStage.show();
}