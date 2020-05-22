/* package */ SQLiteProgram(SQLiteDatabase db, String sql) {
    mDatabase = db;
    mSql = sql.trim();
    db.acquireReference();
    db.addSQLiteClosable(this);
    this.nHandle = db.mNativeHandle;

    // only cache CRUD statements
    String prefixSql = mSql.substring(0, 6); // <<<< HERE