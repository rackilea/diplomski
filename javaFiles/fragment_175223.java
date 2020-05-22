@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return bookIndex == book.bookIndex &&
            year == book.year &&
            Double.compare(book.cost, cost) == 0 &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author);
}