public boolean compareLogin(String username, String pass) {
    String where = DB_COL_EMAIL + " = ? AND " + DB_COL_PASS + " = ?";  
    String[] whereParams = new String[]{username, pass};

    Cursor mCursor = db.query(DB_NAME, columns, 
            where, 
            whereParams, 
            null, 
            null, 
                null);

    if (mCursor != null && mCursor.moveToFirst())
        return true;
    else
        return false;
}