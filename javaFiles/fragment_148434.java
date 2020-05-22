package sample;

public class DatabaseManager {

    public static void initialize() {
        // Query the database for your information.
        // Little pseudo code here
        Data.setUsers(Database.userQuery);
        Data.setContacts(Database.contactQuery);
        Data.setProducts(Database.productQuery);
    }

}