@Override
public void start(Stage primaryStage) {
    ToggleButton b1 = new ToggleButton(),
            b2 = new ToggleButton(),
            b3 = new ToggleButton();

    b1.setStyle("-fx-original-background: black;");
    b2.setStyle("-fx-original-background: red;");
    b3.setStyle("-fx-original-background: yellow;");

    VBox root = new VBox(b1, b2, b3);
    root.getStyleClass().add("toggle-container");
    root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    Scene scene = new Scene(root);

    // alternative place to add the stylesheet
    // scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}