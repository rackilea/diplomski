ComboBox<Dummy> comboBox = ...

Callback<ListView<Dummy>, ListCell<Dummy>> factory = lv -> new ListCell<Dummy>() {

    @Override
    protected void updateItem(Dummy item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? "" : item.getName());
    }

};

comboBox.setCellFactory(factory);
comboBox.setButtonCell(factory.call(null));