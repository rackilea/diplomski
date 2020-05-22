@Override
public void start(Stage primaryStage) {
    ComboBox<String> fontChoice = new ComboBox<>(FXCollections.observableList(Font.getFontNames()));

    Spinner<Integer> spinner = new Spinner<>(1, 40, 12);

    Text text = new Text("Hello World!");

    text.fontProperty().bind(Bindings.createObjectBinding(() -> new Font(fontChoice.getValue(), spinner.getValue()), spinner.valueProperty(), fontChoice.valueProperty()));

    HBox hBox = new HBox(fontChoice, spinner);
    StackPane.setAlignment(hBox, Pos.TOP_CENTER);

    StackPane root = new StackPane(hBox, text);

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}