List<Book> books = this.sf.getCurrentSession().createSQLQuery("select * from Book where book_id > 3")
                         .addEntity(Book.class)
                          .list();
    for (Book book : books) {
        System.out.println("Book Names are :: " + book.getBookName());
    }