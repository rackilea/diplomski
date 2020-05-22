public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private TableView<Task> tableView;

    @FXML
    private TableColumn<Task, String> nameTableColumn;

    @FXML
    private Button addButton;

    @FXML
    private void initialize() {
        nameTableColumn.setCellValueFactory(cdf -> cdf.getValue().nameProperty());

        addButton.disableProperty().bind(Bindings.isEmpty(textField.textProperty()));

        CompletableFuture.supplyAsync(this::loadAll)
            .thenAccept(list -> Platform.runLater(() -> tableView.getItems().setAll(list)))
            .exceptionally(this::errorHandle);
    }

    @FXML
    private void handleAddButton(ActionEvent event) {
        CompletableFuture.supplyAsync(this::addTask)
                .thenAccept(task -> Platform.runLater(() -> {
                    tableView.getItems().add(task);

                    textField.clear();
                    textField.requestFocus();
                }))
                .exceptionally(this::errorHandle);
    }

    private Task addTask() {
        try {
            Task task = new Task(textField.getText());
            ToDoListModel.getInstance().addTask(task);

            return task;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ObservableList<Task> loadAll() {
        try {
            return ToDoListModel.getInstance().getTaskList();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Void errorHandle(Throwable throwable) {
        throwable.printStackTrace();
        return null;
    }
}