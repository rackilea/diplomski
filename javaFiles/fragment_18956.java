public int delete(String table, String whereClause, String[] whereArgs) {
    ...
    SQLiteStatement statement = new SQLiteStatement(this, "DELETE FROM " + table +
            (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);
    try {
        return statement.executeUpdateDelete();
    } finally {
        statement.close();
    }
    ...
}