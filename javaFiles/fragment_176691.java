private double startX;

@Override
public void start(Stage stage) throws Exception {
    BorderPane root = new BorderPane();

    ObservableList<String> names = FXCollections.observableArrayList(
            "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
    ListView<String> listView = new ListView<>(names);

    listView.setOnMousePressed(e -> {
        startX = e.getX();
    });

    listView.setOnMouseReleased(e -> {
        if (Math.abs(e.getX() - startX) > 100) {
            listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
        }
    });
    Scene scene = new Scene(root, 1000, 650);
    stage.setScene(scene);
    stage.show();
}