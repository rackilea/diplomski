ComboBox<String> comboBox = new ComboBox<>();
ObservableList<String> items = FXCollections.observableArrayList();

// Set the ComboBox to use the items list
comboBox.setItems(items);

// Allow the user to update the items in the list
items.add("A new String");