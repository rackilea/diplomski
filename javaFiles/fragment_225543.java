public Book findBookByName(String bookNameToFind) {
    for (Book book : bookLibrary) {
        if (bookNameToFind.equals(book.getTitle()))
            return book; 
    }
    return null;
}