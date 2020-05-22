for (int i = 1; i <= 1; i++) {
    book = dao.listBookDetailsById(Integer.parseInt(bookid));    
    books.add(book);
    books = new ArrayList<Bookdetails>(); // <-- Now it's a new, empty list?!
}
session.put(BillTransactionBooksConstants.BOK, books);