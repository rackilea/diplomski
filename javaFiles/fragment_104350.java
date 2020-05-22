public class Contact implements Comparable<Contact> {
    private string name;

    public int compareTo(Contact contact) {
        return name.compareTo(contact.name);
    }
}