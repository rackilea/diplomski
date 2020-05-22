package sample;

public class Data {

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public static ArrayList<Contact> getContacts() {
        return contacts;
    }

    public static void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();
    private static ArrayList<Product> products = new ArrayList<Product>();

}