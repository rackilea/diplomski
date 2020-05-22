@FXML 
private TableView<Symptom> symptomsTable;

@FXML
private TableColumn<Symptom,String> nameColumn;

@FXML
private TableColumn<Symptom,String> categoryColumn;

// value for the action column is just going to be the entire symptom,
// so the type of the column is TableColumn<Symptom, Symptom>
@FXML
private TableColumn<Symptom,Symptom> actionColumn;

@Override
public void initialize(URL url, ResourceBundle rb) {
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

    // just provide the entire row as the value for cells in the actionColumn:
    actionColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

    // cell factory which provides cell which display a button:
    actionColumn.setCellFactory(column -> new TableCell<Symptom, Symptom>() {
        private final Button button = new Button("Select Symptom");

        {
            button.setOnAction(e -> {
                Symptom symptom = getItem();
                // do whatever you need with symptom..
            });
        }

        @Override
        protected void updateItem(Symptom item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(button);
            }
        }
    });

    symptomsTable.setItems(loginModelSymptomsTable.selectSymptomValue());

}