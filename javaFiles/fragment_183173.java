public class OverviewController {

    ...

    @FXML
    private TableColumn<Task, String> statusColumn;

    ...

    @FXML
    private void initialize() {
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
    }

}