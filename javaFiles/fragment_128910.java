public class Book {
    private Person author;
    private String title;

    public Book(String author, String title) {
        this.author = new Person(author);
        this.title = title;
    }
}

class Person {

    private String name;
    private double height;
    public static final double DEFAULT_HEIGHT = 0.0;

    Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    Person(String name) {
        this(name, DEFAULT_HEIGHT);
    }
}