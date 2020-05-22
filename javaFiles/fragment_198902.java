@Override
public void start(Stage primaryStage) {
    // create data
    ObservableList<Item<String>> data1 = FXCollections.observableArrayList(
            new Item("A"),
            new Item("B"),
            new Item("C"),
            new Item("D")
    );
    ObservableList<Item<String>> data2 = FXCollections.observableArrayList(
            new Item("A"),
            new Item("B"),
            new Item("C"),
            new Item("D")
    );

    // create tableview & columns
    TableView<Item<String>> table1 = new TableView<>(data1);
    TableView<Item<String>> table2 = new TableView<>(data2);

    TableColumn<Item<String>, String> column1 = new TableColumn<>();
    column1.setCellValueFactory(new PropertyValueFactory("value"));

    TableColumn<Item<String>, String> column2 = new TableColumn<>();
    column2.setCellValueFactory(new PropertyValueFactory("value"));

    table1.getColumns().add(column1);
    table2.getColumns().add(column2);

    // create maps mapping values to values to select in the other table,
    // should a item be selected
    Map<Item<String>, List<Item<String>>> selection1To2 = new HashMap<>();
    selection1To2.put(data1.get(0), Arrays.asList(data2.get(0), data2.get(1)));
    selection1To2.put(data1.get(2), Arrays.asList(data2.get(1), data2.get(2)));

    Map<Item<String>, List<Item<String>>> selection2To1 = new HashMap<>();
    selection2To1.put(data2.get(1), Arrays.asList(data1.get(2), data1.get(3)));
    selection2To1.put(data2.get(3), Arrays.asList(data1.get(0), data1.get(1), data1.get(2), data1.get(3)));

    // sets of items to select depending on table selections
    ObservableSet<Item<String>> otherSelections1 = connect(table2, selection2To1);
    ObservableSet<Item<String>> otherSelections2 = connect(table1, selection1To2);

    // assign row factories for assigning pseudoclasses
    table1.setRowFactory(new RowFactory(otherSelections1));
    table2.setRowFactory(new RowFactory(otherSelections2));

    Scene scene = new Scene(new HBox(10, table1, table2));
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
}

private static <T> ObservableSet<T> connect(TableView<T> table, Map<T, List<T>> map) {
    ObservableSet<T> result = FXCollections.observableSet(new HashSet<>());

    // keep set elements the union of the list elements for the items selected in the table
    table.getSelectionModel().getSelectedItems().addListener((Observable o) -> {
        result.clear();
        for (T item : table.getSelectionModel().getSelectedItems()) {
            List<T> itemsToAdd = map.get(item);
            if (itemsToAdd != null) {
                result.addAll(itemsToAdd);
            }
        }
    });
    return result;
}

private static final PseudoClass OTHER_SELECTED = PseudoClass.getPseudoClass("other-selected");

private static class RowFactory implements Callback<TableView<Item<String>>, TableRow<Item<String>>> {

    private final ObservableSet<Item<String>> selected;

    public RowFactory(ObservableSet<Item<String>> selected) {
        this.selected = selected;
    }

    @Override
    public TableRow<Item<String>> call(TableView<Item<String>> param) {
        // rows contain pseudoclass depending on other selection
        return new TableRow<Item<String>>() {

            {
                selected.addListener((Observable o) -> updateOtherSelected());
            }

            @Override
            protected void updateItem(Item<String> item, boolean empty) {
                super.updateItem(item, empty);
                updateOtherSelected();
            }

            private void updateOtherSelected() {
                pseudoClassStateChanged(OTHER_SELECTED, selected.contains(getItem()));
            }

        };
    }

}