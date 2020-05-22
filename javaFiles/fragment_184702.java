Platform.startup(() -> {
    Group root;
    try {
        Stage stage = new Stage();
        root = new Group();
        Scene scene = new Scene(root);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("myGui.fxml"));
        Node node = loader.load();

        // Controller stuff

        root.getChildren().add(node);
        stage.setScene(scene);
        stage.setOnHidden(evt -> Platform.exit()); // make sure to completely shut down JavaFX when closing the window
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
});