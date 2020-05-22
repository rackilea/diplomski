TableColumn<Product, Integer> aColumn = new TableColumn<>("A");
aColumn.setMinWidth(100);
aColumn.setCellValueFactory(new PropertyValueFactory<>("A"));

TableColumn<Product, Integer> bColumn = new TableColumn<>("B");
bColumn.setMinWidth(100);
bColumn.setCellValueFactory(new PropertyValueFactory<>("B"));

TableColumn<Product, Integer> fColumn = new TableColumn<>("F");
fColumn.setMinWidth(100);
fColumn.setCellValueFactory(new PropertyValueFactory<>("F"));

table = new TableView<>();
getProductsFromFile();
table.getColumns().addAll(aColumn, bColumn, fColumn);