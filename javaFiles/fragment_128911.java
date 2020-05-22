public class Book {
    private Person author;
    private String title;

    public Book(Person author, String title) {
        this.author = author.getName();
        this.title = title;
    }
}