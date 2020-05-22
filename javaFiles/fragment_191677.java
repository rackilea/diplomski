public class Person {
    // parameters are "owning bean" (i.e. this person), property name, and initial value:
    private final StringProperty name = new SimpleStringProperty(this, "name", "Fred");
    public StringProperty nameProperty() {
        return name ;
    }
    public final String getName() {
        return nameProperty().get();
    }
    public final void setName(String name) {
        nameProperty().set(name);
    }
    // ...
}