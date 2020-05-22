listView.setCellFactory(v -> new ListCell<>() {

    {
        setStyle("-fx-padding: 0px");
    }

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            // your custom display logic
        }
    }

});