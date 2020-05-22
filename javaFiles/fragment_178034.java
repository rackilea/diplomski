private boolean checkOldDatabase() {
    Log.d(Constants.LOGTAG, "OperationDbHelper.checkDatabase");
    File f = new File(DB_PATH + OLD_DB_NAME);
    return f.exists();
}

public void createDatabaseIfRequired() throws IOException, SQLiteException {
    if (!checkOldDatabase()) {
      // do db comparison / delete old db / copy new db
    }
}