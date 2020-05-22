public class Author {
    int authorID;
    String firstName;
    String lastName;
    ArrayList<Integer> bookIds;
    Storage storage;

    public Author(Storage storage) {
        this.storage = storage;
    }

    public void addBook(Book book) {
        storage.addBook(book);
        bookIds.add(book.ISPN);
    }

    public List<Book> createBooksList() {
        List<Book> bookList = new ArrayList<>();
        for (Integer bookId : bookIds) {
            bookList.add(storage.getBook(bookId));
        }
        return bookList;
    }
}