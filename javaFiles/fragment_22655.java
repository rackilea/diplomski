// Fill the list from the DataBase
ObservableList<AirPort> airports = FXCollections.observableArrayList();
airports.addAll(new AirPort(0, "Heathrow"), 
    new AirPort(1, "Frankfurt"),
    new AirPort(2, "NewYork"));

ComboBox<AirPort> combo = new ComboBox<>();
combo.setItems(airports);