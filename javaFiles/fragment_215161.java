db.beginTransaction();

try {
  // your SQL goes here
  db.setTransactionSuccessful();
}
finally {
  db.endTransaction();
}