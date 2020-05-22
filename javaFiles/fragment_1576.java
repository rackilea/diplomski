public synchronized SQLiteDatabase getWritableDatabase() {
    if (mDatabase != null && mDatabase.isOpen() && !mDatabase.isReadOnly()) {
        return mDatabase;  // The database is already open for business
    }

    if (mIsInitializing) {
        throw new IllegalStateException("getWritableDatabase called recursively");
    }

    // If we have a read-only database open, someone could be using it
    // (though they shouldn't), which would cause a lock to be held on
    // the file, and our attempts to open the database read-write would
    // fail waiting for the file lock.  To prevent that, we acquire the
    // lock on the read-only database, which shuts out other users.

    boolean success = false;
    SQLiteDatabase db = null;
    if (mDatabase != null) mDatabase.lock();
    try {
        mIsInitializing = true;
        if (mName == null) {
            db = SQLiteDatabase.create(null);
        } else {
            db = mContext.openOrCreateDatabase(mName, 0, mFactory);
        }

        int version = db.getVersion();
        if (version != mNewVersion) {
            db.beginTransaction();
            try {
                if (version == 0) {
                    onCreate(db);
                } else {
                    onUpgrade(db, version, mNewVersion);
                }
                db.setVersion(mNewVersion);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }

        onOpen(db);
        success = true;
        return db;
    } finally {
        mIsInitializing = false;
        if (success) {
            if (mDatabase != null) {
                try { mDatabase.close(); } catch (Exception e) { }
                mDatabase.unlock();
            }
            mDatabase = db;
        } else {
            if (mDatabase != null) mDatabase.unlock();
            if (db != null) db.close();
        }
    }
}