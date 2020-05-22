private TableView<Person> createTableView(){
    ObservableList<Person> persons = createItems();
    List<TableColumn> columns = createColumns(persons);

    TableView<Person> tableView = new TableView();
    tableView.getColumns().addAll(columns.toArray(new TableColumn[0]));
    tableView.setItems(persons);
    return tableView;
}