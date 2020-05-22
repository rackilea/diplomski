public class Database {

    private static Database singleObject;
    private int record;
    private String name;

    private Database(String n) {
        name = n;
        record = 0;
    }

    public static synchronized Database getInstance(String n) {
        if (singleObject == null) {
            singleObject = new Database(n);
        }

        return singleObject;
    }

    public void doSomething() {
        System.out.println("Hello StackOverflow.");
    }

    public String getName() {
        return name;
    }
}