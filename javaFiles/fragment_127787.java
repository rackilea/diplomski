package de.scrum_master.app;

public class Application {
    public static final double PI = Math.PI;
    static String producer = "Scrum-Master.de";

    private int id = 11;
    private String author = "Alexander Kriegisch";
    private final String COUNTRY = "Germany";

    public static void main(String[] args) {
        Object dummy;
        Application application = new Application();

        // Access static fields
        dummy = PI;
        dummy = producer;
        // Access non-static fields
        dummy = application.author;
        dummy = application.id;
        dummy = application.COUNTRY;
    }
}