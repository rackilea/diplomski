static List<Contact> contacts = new ArrayList<>();

public static void main(String[] args) {
    Contact contact = new Contact();
    contact.setNumber(-17);
    contact.setName("contact name");
    contacts.add(contact);
    listAllContact();
}

private static void listAllContact() {
    if (contacts.size() != 0) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + contacts.get(i).getName());
        }
    } else {
        System.out.println("Contact book is empty.");
    }
}

static class Contact {
    private long number;
    private String name;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}