private boolean checkDataBase() {
    File dbFile = myContext.getDatabasePath(DB_NAME);
    if (dbFile.exists()) return true;
    if (!dbFile.getParentFile().exists()) {
        dbfile.getParentFile().mkdirs();
    }
    return false;
}