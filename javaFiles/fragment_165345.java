ListView<Person> list = new ListView<>();

    ObservableList<Person> items = FXCollections.observableArrayList();
    for (int i = 0; i < 20; i++) {
        items.add(new Person("First Name "+i, "Last Name "+i));
    }
    list.setItems(items);

    list.setCellFactory(lv -> new PersonCell());