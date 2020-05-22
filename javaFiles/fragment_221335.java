public class Storage implements Serializable {
    private final HashMap<Integer, Book> books;
    private final HashMap<Integer, Author> authors;

    public Storage() {
        books = new HashMap<>();
        authors = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.ISPN, book);
    }

    public void removeBook(Book book) {
        books.remove(book.ISPN);
    }

    public void addAuthor(Author author) {
        authors.put(author.authorID, author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author.authorID);
    }

    public Author getAuthor(Integer authorId) {
        return authors.get(authorId);
    }

    public Book getBook(Integer bookId) {
        return books.get(bookId);
    }
}