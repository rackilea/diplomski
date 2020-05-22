public class Person {

    private final StringProperty name = new SimpleStringProperty();

    public StringProperty nameProperty() {
        return name ;
    }

    public final String getName() {
        return nameProperty().get();
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    private final ObjectProperty<Address> address = new SimpleObjectProperty<>();

    public ObjectProperty<Address> addressProperty() {
         return address ;
    }

    public Address getAddress() {
        return addressProperty().get();
    }

    public void setAddress(Address address) {
        addressProperty().set(address);
    }

    // other properties...
}