private ObservableList<Person> createItems() {
    ObservableList items = FXCollections.observableArrayList();
    items.add(new Person(0,1,2,3,4));
    items.add(new Person(2,3));
    return items;
}