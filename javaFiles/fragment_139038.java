TableView tab = new TableView();

TableColumn nameColumn = new TableColumn("Name");
nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

TableColumn surnameColumn = new TableColumn("Surname");
surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

tab.getColumns().addAll(nameColumn, surnameColumn);