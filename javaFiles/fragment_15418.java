class ContactManager {

   List<Contact> contacts = new ArrayList<>();        

    public List<Contact> contacts() {
        return Collection.unmodifiableList(contacts);
    }

    public void addContact(String name) {
       contacts.add(new Contact(name));
    }
}