public static class Musicians {

    private final StringProperty category = new SimpleStringProperty();
    private final ListProperty<Person> persons = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Musicians() { }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setPersons(ObservableList<Person> value) {
        this.persons.set(value);
    }

    public ObservableList<Person> getPersons() {
        return persons.get();
    }

    public ListProperty<Person> personsProperty() {
        return persons;
    }
}