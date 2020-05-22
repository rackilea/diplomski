public synchronized SQLiteDatabase getReadableDatabase() {
    if (mDatabase != null && mDatabase.isOpen()) {
        return mDatabase;  // The database is already open for business
    }

    if (mIsInitializing) {
        throw new IllegalStateException("getReadableDatabase called recursively");
    }

    try {
        return getWritableDatabase();
    } catch (SQLiteException e) {
        if (mName == null) throw e;  // Can't open a temp database read-only!
        Log.e(TAG, "Couldn't open " + mName + " for writing (will try read-only):", e);
    }

    SQLiteDatabase db = null;
    try {
        mIsInitializing = true;
        String path = mContext.getDatabasePath(mName).getPath();
        db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READONLY);
        if (db.getVersion() != mNewVersion) {
            throw new SQLiteException("Can't upgrade read-only database from version " +
                    db.getVersion() + " to " + mNewVersion + ": " + path);
        }

        onOpen(db);
        Log.w(TAG, "Opened " + mName + " in read-only mode");
        mDatabase = db;
        return mDatabase;
    } finally {
        mIsInitializing = false;
        if (db != null && db != mDatabase) db.close();
    }
}