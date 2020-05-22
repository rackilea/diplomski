public void deleteBook(Book book) {
        // Book mergedBook = em.merge(book);
        Book b1=em.find(Book.class,book.getId);
        em.remove(b1);
        logger.info("Book with id: " + mergedBook.getId()  + " deleted successfully");
    }