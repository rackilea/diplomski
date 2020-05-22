public class StartController {
    @FXML
    private AnchorPane createCharacterPanel;

    @FXML
    private VBox child;

    private Parent loadFXML(String name) {
        try {
            return FXMLLoader.load(getClass().getResource(name));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @FXML
    private void handleLoadFXML(ActionEvent event) {
        child.getChildren().addAll(
            loadFXML("pane_a.fxml"),
            loadFXML("pane_b.fxml")
        );
    }
}