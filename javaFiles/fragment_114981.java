/**
     * This function takes a book title and search in the book array.
     * 
     * @param title
     * @return returns null if title is not found.
     */
    public Book findBookByTitle(String title) {
        Book searchBook = null;
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                searchBook = book;
                break;
            }
        }
        return searchBook;
    }