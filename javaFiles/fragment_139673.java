Map<String, List<Book>> bookShelf = new HashMap<String, List<Book>>();

void addBook(Book book) {
    String key = book.name + book.author; // For illustration
    List<Book> bookList = null;
    if (!bookShelf.containsKey(key)) {
        bookList = new ArrayList<Book>();
        bookShelf.put(key, bookList);
    } else {
        bookList = bookShelf.get(key);
    }
    bookList.add(book);
}

double fetchAverage(Book input){
    String key = ""/*key logic*/;
    List<Book> booklist =  bookShelf.get(key);
    double avg = 0.0;
    for(Book b: booklist){
        avg += b.price;
    }
    return avg/booklist.size();
}