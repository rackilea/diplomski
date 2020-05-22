@Named
@RequestScoped
public class BookController {

    private Book book;
    private List<Book> books;

    @EJB
    private BookService service;

    @PostConstruct
    public void init() {
        book = new Book();
        books = service.list();
    }

    public void add() {
        service.save(book);
        init();
    }

    public Book getBook() { 
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }

}