public class Person {
    private String id;
    private String firstName;
    private String surname;

    public Person(String id, String fname, String sname) {
        this.id = id;
        this.firstName = fname;
        this.surname = sname;
    }

    public String getId() {
         return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
         return surname;
    }

    // toString() method will be called when the ComboBox is rendered
    @Override
    public String toString() {
        return id + " > " + firstName + " " + surname;
    }
}