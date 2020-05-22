Shelves shl1 = new Shelves("Shelf 1");

Book ph1 = new Book("BA001", 1990, "McDonalds", "Shakepike", "Novel");
shl1.addBook(ph1);
Book ph2 = new Book("BA002", 2004, "How to save the world", "Shakepike",  "Non-Fiction");
shl1.addBook(ph2);

shl1.displayShelf(); //Display Shelve name and its book