try {
    new RowName.delete(new RowName.get(1));
    fail("It should not be possible to call .delete. DB should throw an exception since this is a violation of a constraint.");
} catch (org.sqlite.SQLiteException e) {
    // Just continue. We expect an SQLiteException since the test data has a 
    // constraint that forbids the .delete.
}
// Any other exception that is thrown will cause the test to fail which
// is what we want. The SQLiteException is expected since you forced it
// to happen. Other exceptions have to be examined and handled.