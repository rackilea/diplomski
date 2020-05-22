package acme.db;

public class Driver {

    static {
        java.sql.DriverManager.registerDriver(new Driver());
    }

    ...
}