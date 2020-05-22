DatabaseController db = DatabaseController.getInstance(context);

db.openDatabase();


Book book = new Book("Alice in Wonderland");

book.save(db);

db.close();