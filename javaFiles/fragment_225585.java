public class Controller {

    @FXML
    private ListView<Task> listView;

    @FXML
    private void initialize() {
        listView.setCellFactory(new TaskCellFactory());
    }
}