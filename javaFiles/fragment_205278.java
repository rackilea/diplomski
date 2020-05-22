public class BookDaoImpl implements BookDao
{
    private static BookDaoImpl INSTANCE = null;

    private Monarchy monarchy;

    private BookDaoImpl(Monarchy monarchy)
    {
        this.monarchy = monarchy;
    }

    public static BookDaoImpl getInstance(Monarchy monarchy)
    {
        if (INSTANCE == null) {
            synchronized(BookDaoImpl.class) {
                if(INSTANCE == null) {
                    INSTANCE = new BookDaoImpl(monarchy);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Book> getAllBooks()
    {
        return monarchy.fetchAllCopiedSync((realm) -> realm.where(Book.class));
    }

    @Override
    public Book getBookById(final String id)
    {
        List<Book> books = monarchy.fetchAllCopiedSync((realm) -> realm.where(Book.class).equalTo("id", id));
        if(books.isEmpty()) {
            return null;
        } else {
            return books.get(0);
        }
    }

    @Override
    public void saveBook(final Book book)
    {
        monarchy.runTransactionSync((realm) -> {
            if (book.getId() == null)
                book.setId(UUID.randomUUID().toString());
            realm.insertOrUpdate(book);
        });
    }

    @Override
    public void deleteBook(final Book book)
    {
        monarchy.runTransactionSync((realm) -> {
                realm.where(Counter.class).equalTo("id", book.getId())
                        .findFirst()
                        .deleteFromRealm();
        });
    }
}