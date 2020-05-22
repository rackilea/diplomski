public class Person {

    private final StringProperty personName = new SimpleStringProperty();

    public StringProperty personNameProperty() {
        return personName ;
    }

    public final String getPersonName() {
        return personNameProperty().get();
    }

    public final void setPersonName(String name) {
        personNameProperty().set(name);
    }
}