@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;

    Book book = (Book) o;

    if (bookIndex != book.bookIndex) return false;
    if (year != book.year) return false;
    if (Double.compare(book.cost, cost) != 0) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;
    return author != null ? author.equals(book.author) : book.author == null;
}