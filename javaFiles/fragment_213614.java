ObservableMap<String, Shape> map = FXCollections.observableHashMap();

ObservableList<MapEntry<String, Shape>> entries = FXCollections.observableArrayList();

map.addListener((MapChangeListener.Change<? extends String, ? extends Shape> change) -> {
    boolean removed = change.wasRemoved();
    if (removed != change.wasAdded()) {
        if (removed) {
            // no put for existing key
            // remove pair completely
            entries.remove(new MapEntry<>(change.getKey(), (Shape) null));
        } else {
            // add new entry
            entries.add(new MapEntry<>(change.getKey(), change.getValueAdded()));
        }
    } else {
        // replace existing entry
        MapEntry<String, Shape> entry = new MapEntry<>(change.getKey(), change.getValueAdded());

        int index = entries.indexOf(entry);
        entries.set(index, entry);
    }
});

map.put("one", new Shape("a", 1));
map.put("two", new Shape("b", 2));
map.put("three", new Shape("c", 3));

final TableView<MapEntry<String, Shape>> table = new TableView<>(entries);
TableColumn<MapEntry<String, Shape>, String> column1 = new TableColumn<>("Key");

// display item value (= constant)
column1.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue().getKey()));

TableColumn<MapEntry<String, Shape>, String> column2 = new TableColumn<>("formula");
column2.setCellValueFactory(cd -> cd.getValue().getValue().areaFormulaProperty());

TableColumn<MapEntry<String, Shape>, Number> column3 = new TableColumn<>("sides");
column3.setCellValueFactory(cd -> cd.getValue().getValue().numSidesProperty());

table.getColumns().setAll(column1, column2, column3);