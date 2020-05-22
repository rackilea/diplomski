// given
final String isbn1 = randomIsbn();
final String isbn2 = randomIsbn();
final Book[] books = { new Book(isbn1), new Book(isbn2) };

// when
bookRepository.store(books);