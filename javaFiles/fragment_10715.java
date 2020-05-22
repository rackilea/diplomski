/** changed item to 
 *  - use property and notify on change
 *  - not override toString (for visuals, use converter instead)
 */ 
class Test {
    StringProperty name;

    public Test(String name) {
        setName(name);
    }

    public StringProperty nameProperty() {
         if (name == null) name = new SimpleStringProperty(this, "name");
         return name;
    }
    public void setName(String name) {
        nameProperty().set(name);
    }

    public String getName() {
        return nameProperty().get();
    }

} 

// use in collection with extractor
ObservableList<Test> items = FXCollections.observableList(
    e -> new Observable[] {e.nameProperty()} );
items.addAll(...);
choiceBox = new ChoiceBox<>(items);
// tell the choice how to represent the item
StringConverter<Test> converter = new StringConverter<Test>() {

    @Override
    public String toString(Test album) {
        return album != null ? album.getName() : null;
    }

    @Override
    public Test fromString(String string) {
        return null;
    }

};
choiceBox.setConverter(converter);