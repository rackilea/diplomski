// ...
    List<Book> list = new ArrayList<>();
    for (int i=0; i<bookId.length;i++) {
        list.add(this.bookBean.retrieveBook(bookId[i]));
    }       
    author.setBookList(list);        
    // ...