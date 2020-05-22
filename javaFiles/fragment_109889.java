public Scene getScene() {
    VBox root = new VBox();
    Scene scene = new Scene(root, Color.ALICEBLUE);
    root.getChildren().addAll(getPieChart());
    return scene;
}