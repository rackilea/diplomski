public class Person {

    private StringProperty name = new SimpleStringProperty("");

    public Person(String name) {
        this.name.setValue(name);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public StringProperty nameProperty() {
        return name;
    }
}