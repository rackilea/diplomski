public Book(String bookTitle, Map<Integer, String> authors, String bookType, String bookStyle, String isbn, int numberOfPages) throws InvalidDataException {
    setBookTitle(bookTitle);
    setAuthors(authors);
    setType(bookType);
    setStyle(bookStyle);
    setISBN(isbn);
    setNumberOfPages(numberOfPages);
}

public Book(String bookTitle, Map<Integer, String> authors, String bookType) throws InvalidDataException {
    this(bookTitle, authors, bookType, null, null, null);
}

@Override
public String toString() {
    String result = String.format("Book: %s Author(s): %s Genre: %s",
            getBookTitle(), loopAuthors(), bookType);
    if (getBookStyle() == null && getISBN() == null && getNumberOfPages() == null)
        return result;
    return String.format("%s Book Style: %s ISBN-10: %s Number of Pages: %s",
            result, getBookStyle(), getISBN(), getNumberOfPages());
}