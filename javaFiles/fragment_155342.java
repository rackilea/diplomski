@Override
public void start(Stage primaryStage) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "foo");
    map.put(23, "bar");

    ObservableList<Integer> keys = FXCollections.observableArrayList(map.keySet());

    TableView<Integer> table = new TableView<>(keys);

    TableColumn<Integer, Integer> column1 = new TableColumn<>("Key");
    column1.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue()));

    TableColumn<Integer, String> column2 = new TableColumn<>("Value");
    column2.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue())));

    table.setEditable(true);
    column1.setEditable(true);
    table.getColumns().setAll(column1, column2);

    column1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    column1.setOnEditCommit(t -> {
        Integer key = t.getRowValue();
        Integer newKey = t.getNewValue();
        if (!key.equals(newKey)) {
            if (map.containsKey(newKey)) {
                // make sure this cell's value remains unmodified
                table.refresh();
            } else {
                int rowIndex = t.getTablePosition().getRow();
                map.put(newKey, map.remove(key));
                keys.set(rowIndex, newKey);
            }
        }
    });
    column2.setCellFactory(TextFieldTableCell.forTableColumn());
    column2.setOnEditCommit(t -> {
        Integer key = t.getRowValue();
        map.put(key, t.getNewValue());
    });

    Scene scene = new Scene(table);

    primaryStage.setScene(scene);
    primaryStage.show();
}