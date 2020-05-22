public class MainController {

    // fields for injection of nested controllers
    @FXML
    private InfoDisplayController displayController;
    @FXML
    private InfoTableController tableController;

    @FXML
    private void initialize() {
        // connect selected table item with displayed document
        tableController.selectedItemProperty().addListener((o, oldValue, newValue) -> {
            final String id = newValue.getId();
            displayController.displayDocument(id);
        });
    }

    public void updateTable(final List<Info> infoList) {
        tableController.updateTable(infoList);
    }
}