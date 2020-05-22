@Override
public void start(Stage primaryStage) {
    TitledPane root = new TitledPane();
    root.setText("Options");
    primaryStage.setScene(new Scene(root, 200, 100));
    primaryStage.show();

    root.lookup(".titled-pane > .title > .text").setStyle("-fx-font-weight: bold;");
}