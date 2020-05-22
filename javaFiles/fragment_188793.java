beginTransaction();
try {
     // db operations...

     setTransactionSuccessful(); // didn't throw so far
} finally {
     endTransaction(); // rollback or commit
}