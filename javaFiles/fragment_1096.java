private void initializeTableView() {


    personTableView.setItems(myList);
    personTableView.setEditable(true);
    // fNameCol = new TableColumn<>("First Name");
    fNameCol.setCellFactory(new PropertyValueFactory("firstName"));
    // lNameCol = new TableColumn<>("Last Name");
    lNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
}