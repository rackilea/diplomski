public int increasePoints(String user, int points_to_add) {
    SQLiteDatabase db = this.getWritableDatabase();
    SQLiteStatement sql = db.compileStatement(
            "UPDATE " + TABLE_NAME2 +
                    " SET " + POINTS + "=" + POINTS + " +?  " +
                    "WHERE "+ NICKNAME + "=?"
    );
    sql.bindLong(1,points_to_add);
    sql.bindString(2,user);
    return sql.executeUpdateDelete();
}

public int getPoints(String user) {
    SQLiteDatabase db = this.getWritableDatabase();
    int rv = -1;
    String whereclause = NICKNAME + "=?";
    String[] whereargs = new String[]{user};
    Cursor csr = db.query(TABLE_NAME2,new String[]{POINTS},whereclause,whereargs,null,null,null);
    if (csr.moveToFirst()) {
        rv = csr.getInt(csr.getColumnIndex(POINTS));
    }
    csr.close();
    return rv;
}