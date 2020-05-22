TableView<SomeDataType> table = new TableView<>();

Map<TableColumn<SomeDataType, ?>, Map<Number, TableCell<SomeDataType, ?>>> cells = new HashMap<>();

TableColumn<SomeDataType, SomeColumnDataType> column = new TableColumn<>(...);
cells.put(column, new HashMap<>();

column.setCellValueFactory(...);

column.setCellFactory(tc -> {
    TableCell<SomeDataType, SomeColumnDataType> cell = new TableCell<SomeDataType, SomeColumnDataType>() {
        @Override
        protected void updateItem(SomeColumnDataType item, boolean empty) {
            super.updateItem(item, empty) ;
            if (empty) {
                setText(null);
            } else {
                setText(item.toString());
            }
        }
    };

    cell.indexProperty().addListener((obs, oldIndex, newIndex) -> {
        if (oldIndex != null) {
            cells.get(column).remove(oldIndex);
        }
        if (newIndex != null && newIndex.intValue() != -1) {
            cells.get(column).put(newIndex, cell);
        }
    });

    return cell ;
});

// repeat for other columns...