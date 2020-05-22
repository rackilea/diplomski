public void addBook(Book bookToAdd) {
    if (bookToAdd == null) {
        throw new IllegalArgumentException("The book to add should not be null");
    }
    books.add(bookToAdd);
}