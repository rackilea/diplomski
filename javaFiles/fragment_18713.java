public void start(Stage primaryStage) {
    ScrollPane scrollPane = new ScrollPane();
    VBox vbox = new VBox();

    for (int i = 0; i < 500; i++) {
        Label label = new Label("Label " + i);
        label.getStyleClass().add("test");
        vbox.getChildren().add(label);

        label.setCache(true);
        label.setCacheShape(true);
        label.setCacheHint(CacheHint.SPEED);
    }

    scrollPane.setContent(vbox);

    Scene scene = new Scene(scrollPane, 500, 500);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    primaryStage.show();
}