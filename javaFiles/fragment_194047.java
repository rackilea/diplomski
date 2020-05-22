ObservableList<Person> persons = FXCollections
        .observableArrayList(p -> new Observable[] { p.nameProperty(), p.countProperty() });
ObservableList<String> uniqueNames = FXCollections.observableArrayList();

persons.addListener((Change<? extends Person> c) -> uniqueNames
        .setAll(persons.stream().map(Person::getName).distinct().collect(Collectors.toList())));

TableView<String> table = new TableView<>(uniqueNames);
TableColumn<String, String> name = new TableColumn<>("Name");
name.setCellValueFactory(n -> new SimpleStringProperty(n.getValue()));
TableColumn<String, Number> count = new TableColumn<>("Count");
count.setCellValueFactory(n -> Bindings.createIntegerBinding(() -> persons.stream()
        .filter(p -> p.getName().equals(n.getValue())).collect(Collectors.summingInt(Person::getCount)), persons));