@FXML
private TableColumn<Student, Number> id ;

@FXML
private TableColumn<Student, String> name ;

public void initialize() {
    id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
    name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    // ...
}