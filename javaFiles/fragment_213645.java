@Override
public void start(Stage primaryStage) {

    TableView<String> tableView = new TableView<>();
    TableColumn<String, String> col1 = new TableColumn<>();
    col1.setCellValueFactory(cb -> new SimpleStringProperty(cb.getValue()));
    tableView.getColumns().add(col1);
    IntStream.range(0, 20).mapToObj(Integer::toString).forEach(tableView.getItems()::add);

    tableView.setFixedCellSize(25);
    tableView.prefHeightProperty().bind(tableView.fixedCellSizeProperty().multiply(Bindings.size(tableView.getItems()).add(1.01)));
    tableView.minHeightProperty().bind(tableView.prefHeightProperty());
    tableView.maxHeightProperty().bind(tableView.prefHeightProperty());

    BorderPane root = new BorderPane(tableView);
    root.setPadding(new Insets(10));
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}