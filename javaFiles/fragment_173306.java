public Book searchClass(String inputClass) {
    for (Book book: bookStore) {
        if (book.getClassification() != null &&
            book.getClassification().equalsIgnoreCase(inputClass))
        {
            return book;
        }
    }

    throw new IllegalArgumentException("book not found");
}