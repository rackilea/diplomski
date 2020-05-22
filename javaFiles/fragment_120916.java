@Override
public void start(Stage primaryStage) {
    TextField textField = new TextField();
    Label label = new Label();
    label.textProperty().bind(textField.textProperty()
                                       .length()
                                       .asString("Character Count: %d"));
    VBox root = new VBox(label, textField);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}