class SomethingElse {}

TableColumn<Person, SomethingElse> numberCol = new TableColumn<Person, SomethingElse>("#");
numberCol.setMinWidth(20);
numberCol.setCellValueFactory(new Callback<CellDataFeatures<Person, SomethingElse>, ObservableValue<SomethingElse>>() {
    @Override public ObservableValue<SomethingElse> call(CellDataFeatures<Person, SomethingElse> p) {
        return new ReadOnlyObjectWrapper<SomethingElse>(new SomethingElse());
    }
});

numberCol.setCellFactory(new Callback<TableColumn<Person, SomethingElse>, TableCell<Person, SomethingElse>>() {
    @Override public TableCell<Person, SomethingElse> call(TableColumn<Person, SomethingElse> param) {
        return new TableCell<Person, SomethingElse>() {
            @Override protected void updateItem(SomethingElse item, boolean empty) {
                super.updateItem(item, empty);

                if (this.getTableRow() != null && item != null) {
                    setText(this.getTableRow().getIndex()+"");
                } else {
                    setText("");
                }
            }
        };
    }
});