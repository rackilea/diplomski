Shelves shl2 = new Shelves("Shelf 2");

Book book1= new Book("BA003", 1992, "Book Name 1", "Author Name", "Novel");
shl2.addBook(book1);
Book book2= new Book("BA004", 2008, "Book Name 2", "Author Name",  "Non-Fiction");
shl2.addBook(book2);

shl2.displayShelf(); //Display Shelve name and its book