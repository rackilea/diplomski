Cursor c = null;
mDb.beginTransaction();

try {
    c = mDb.rawQuery(updateQuery, valVars);
    mDb.setTransactionSuccessful(); 
} catch (Exception e) {
    Log.e("Error in transaction", e.toString());
} finally {
    mDb.endTransaction();
    if (c != null)
        c.close();
}