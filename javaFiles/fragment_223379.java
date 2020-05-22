Book book1 = new Book();
book1.setName("Book2");
book1.setAuthor("Author2"); 

Book book2 = new Book();
book2.setName("Book3");
book2.setAuthor("Author3");

ArrayList<Book> Blist = new ArrayList<Book>();
Blist.add(book1);
Blist.add(book2);

ArrayList<Object> list = new ArrayList<Object>();
list.add(bookstore);
list.addAll(Blist);