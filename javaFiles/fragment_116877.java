import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private Map<String, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public Book get(String isbn) {
        Book copy = null;

        if (this.books.containsKey(isbn))
            copy = new Book(this.books.get(isbn));

        return copy;
    }

    public boolean add(Book book) {
        Book copy = new Book(book);
        return this.books.putIfAbsent(copy.getIsbn(), copy) == null;
    }

    public boolean remove(String isbn) {
        return this.books.remove(isbn) != null;
    }

    public boolean update(Book book) {
        Book copy = new Book(book);
        return this.books.computeIfPresent(copy.getIsbn(), (isbn, existing) -> copy) != null;
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();

        for (Book book : this.books.values())
            list.add(new Book(book));

        return list;
    }

    public void removeAll() {
        this.books.clear();
    }
}