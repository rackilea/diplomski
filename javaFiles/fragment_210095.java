public ArrayList<Book> searchByTitle(String title) {
    ArrayList<Book> found = new ArrayList<Book>();

    for (Book book : found) {
        if (book.title().contains(title)) {
            found.add(book);
        }
    }
    return found;
}