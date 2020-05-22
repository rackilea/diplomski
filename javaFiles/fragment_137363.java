public class Book
{
    private String name;

    private String isbn;

    private String[] authors;

    /* constructor */

    public Book(String name, String isbn, String[] authors) {
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
    }

    /* setter */

    public void setName(String name) {
        this.name = name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /* getter */

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public String[] getAuthors() {
        return authors;
    }
}



public class Main
{
    public static void main(String[] args) {
        Book book1 = new Book(
            "The brief history of time",
            "111",
            new String[]{"S. Hawking", " Hawking's friend"}
        );
        Book book2 = new Book(
            "100 years of solitude",
            "222",
            new String[]{"G. Marquez", "Marquezs friend"}
        );
    }
}