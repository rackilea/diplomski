tableView.setRowFactory(tv -> new TableRow<RowTest>() {
    @Override
    protected void updateItem(final RowTest item, final boolean empty) {
        super.updateItem(item, empty);

        if (!empty && item != null) {
            this.styleProperty().bind(Bindings.createStringBinding(() -> {
                if (item.isValidRow()) {
                    return "-fx-background-color: green;";
                } else {
                    return "-fx-background-color: red;";
                }
            }, item.validRowProperty()));
        } else {
            setText(null);
            setGraphic(null);

            this.styleProperty().unbind();

            setStyle(" ");
        }
    }
});