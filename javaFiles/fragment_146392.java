private final Set<Book> books;
private final Set<Reader> readers;
Predicate<Book> predicate = (book) -> book.getRating() > 3;

public BookSuggestionService(Set<Book> books, Set<Reader> readers) {
    this.books = books;
    this.readers = readers;
}

Set<String> suggestBooks(Reader reader) {
    Set<String> suggestedBooks = new TreeSet<>();

    Set<Book> bookSet = rating(books, predicate);
    bookSet = favouriteGenre(bookSet);
    bookSet = favouriteBooks(bookSet);
    suggestedBooks = getName(bookSet);
    return suggestedBooks;
}

Set<String> suggestBooks(Reader reader, int rating) {
    Set<String> suggestedBooks = new TreeSet<>();
    Set<Book> bookSet = rating(books, (book) -> book.getRating() == rating);
    bookSet = favouriteGenre(bookSet);
    bookSet = favouriteBooks(bookSet);
    suggestedBooks = getName(bookSet);
    return suggestedBooks;
}

Set<String> suggestBooks(Reader reader, Author author) {
    Set<String> suggestedBooks = new TreeSet<>();
    Set<Book> bookSet = rating(books, predicate);
    bookSet = favouriteGenre(bookSet);
    bookSet = favouriteBooks(bookSet);
    bookSet = writtenBy(bookSet, author);
    suggestedBooks = getName(bookSet);
    return suggestedBooks;
}


private Set<Book> rating(Set<Book> bookSet, Predicate<Book> predicate) {
    Set<Book> books = new HashSet<>();
    for (Book book : bookSet) {
        if (predicate.test(book))
            books.add(book);
    }
    return books;
}

private Set<Book> favouriteGenre(Set<Book> bookSet) {
    Set<Book> books = new HashSet<>();

    for (Book book : bookSet) {
        for (Reader reader : readers) {
            if (reader.getFavouriteGenres().contains(book.getGenre())) {
                books.add(book);
                break;
            }
        }
    }
    return books;
}

private Set<Book> favouriteBooks(Set<Book> bookSet) {
    Set<Book> books = new HashSet<>();
    int age = 0;
    for (Book book : bookSet) {
        for (Reader reader : readers) {
            if (reader.getFavouriteBooks().contains(book)) {
                if (age == 0) {
                    age = reader.getAge();
                    books.add(book);
                } else if (age == reader.getAge()) {
                    books.add(book);
                }
            }
        }
    }
    return books;
}

private Set<Book> writtenBy(Set<Book> bookSet, Author author) {
    Set<Book> books = new HashSet<>();
    for (Book book : bookSet) {
        if (book.getAuthor().equals(author)) {
            books.add(book);
        }
    }
    return books;
}

private Set<String> getName(Set<Book> bookSet) {
    Set<String> books = bookSet.stream().map(Book::getTitle).collect(Collectors.toSet());
    return books;
}