@Override
public void start(Stage primaryStage) throws Exception {
    TextField text = new TextField();

    ListView<String> list = new ListView<>();

    PauseTransition delay = new PauseTransition(Duration.seconds(1));
    delay.setOnFinished(evt -> {
        list.getItems().add(text.getText());
    });

    // restart delay every time the text is modified
    text.textProperty().addListener((o, oldValue, newValue) -> delay.playFromStart());

    VBox root = new VBox(text, list);

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}