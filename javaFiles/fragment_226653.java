@Override
public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    String image = this.getClass().getResource("splash.jpg").toExternalForm();
    root.setStyle(" -fx-background-image: url('" + image + "');  "
            + "-fx-background-position: center center; "
            + "-fx-background-repeat: stretch;");
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
}