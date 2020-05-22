public final class MySingleton {
    private static final MySingleton SELF = new MySingleton();

    private List<Contacts> contacts = new ArrayList<Contacts>();
    private boolean didContacts

    private MySingleton() {
        // Don't want anyone else constructing the singleton.
    }

    public static MySingleton getInstance() {
        return SELF;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }
}