SQLiteDatabase db = openOrCreateDatabase("db", MODE_PRIVATE, null);
DaoMaster.createAllTables(db, true);

 db.beginTransaction();
 try {

  DaoMaster daoMaster = new DaoMaster(db);
  DaoSession daoSession = daoMaster.newSession();

  Book book = new Book();
  Book2 book2 = new Book2();

  //insert on specific session
  daoSession.getBookDao().insert(book);

  //set some relation to inserted book
  book2.setBook(book);

  //if this fails, book and book2 won't be in db
  //insert withou specific session
  daoSession.insert(book2); 

  db.setTransactionSuccessful();
} catch (Exception ex) {
    ex.printStackTrace();
} finally {
    db.endTransaction();
    db.close();
}