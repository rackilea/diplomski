ComboBox<Item> comboBox = new ComboBox<>();

comboBox.setItems(FXCollections.observableArrayList(new Item("foo", "17"), new Item("bar", "9")));
comboBox.setConverter(new StringConverter<Item>() {

    @Override
    public Item fromString(String string) {
        // converts string the item, if comboBox is editable
        return comboBox.getItems().stream().filter((item) -> Objects.equals(string, item.getName())).findFirst().orElse(null);
    }

    @Override
    public String toString(Item object) {
        // convert items to string shown in the comboBox
        return object == null ? null : object.getName();
    }
});

// Add listener that prints id of selected items to System.out         
comboBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Item> observable, Item oldValue, Item newValue) -> {
    System.out.println(newValue == null ? "no item selected" : "id=" + newValue.getId());
});