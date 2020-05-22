@Override
public void start(Stage primaryStage) {
    ComboBox<String> familyChoice = new ComboBox<>(FXCollections.observableList(Font.getFamilies()));

    Spinner<Integer> spinner = new Spinner<>(1, 40, 12);

    Text text = new Text("Hello World!");
    text.fontProperty().bind(Bindings.createObjectBinding(() -> Font.font(familyChoice.getValue(), spinner.getValue()), spinner.valueProperty(), familyChoice.valueProperty()));

    HBox hBox = new HBox(familyChoice, spinner);
    StackPane.setAlignment(hBox, Pos.TOP_CENTER);

    StackPane root = new StackPane(hBox, text);

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}