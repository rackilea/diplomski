// single selection mode
button.disableProperty()
        .bind(listView.getSelectionModel().selectedItemProperty().isNull());

// multiple selection mode
button.disableProperty()
        .bind(Bindings.isEmpty(listView.getSelectionModel().getSelectedItems()));