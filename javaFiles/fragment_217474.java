SQLiteDatabase db = openDB();
db.beginTransaction();

try {
    // Add here the loop with all your inserts
    db.setTransactionSuccessful();
} finally {
    db.endTransaction();  // will rollback and cancel the inserts if not marked as successful
    db.close();
}