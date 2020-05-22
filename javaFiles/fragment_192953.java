public class Book {
    private String bookName;
    private Author author; //it should be Author, not String
    private double price;
    private int qty;

    public Book (String bookName, Author name, double price) {
        this.bookName = bookName;
        this.author = name; //here was ur mistake
        this.price = price;
    }

}