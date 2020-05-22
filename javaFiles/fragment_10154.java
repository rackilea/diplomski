public class ContactModel {
    public String id;
    public String name;

    public ContactModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Doing this allows the adapter to display the name without
    // creating a custom getView() implementation
    @Override
    public String toString() {
        return name;
    }
}