@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    //nameColumn
    nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    //allegianceColumn
    allegianceColumn = new TableColumn<>("Allegiance");
    allegianceColumn.setCellValueFactory(new PropertyValueFactory<>("allegiance"));

    //positionColumn
    positionColumn = new TableColumn<>("Position");
    positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

    //salaryColumn
    salaryColumn = new TableColumn<>("Salary");
    salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

    //table = new TableView<>();
    table.setItems(getCharacters());
    table.getColumns().addAll(nameColumn,allegianceColumn,positionColumn,salaryColumn);

}