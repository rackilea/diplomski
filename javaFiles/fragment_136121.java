@FXML private TableView<SimpleFileProperty> table;
@FXML private TableColumn<SimpleFileProperty, String> sizeCol;
final private ObservableList<SimpleFileProperty> tableData =
                                        FXCollections.observableArrayList();
// ...
table.setItems(tableData);