public boolean existIds(int id1, int id2) {
    Cursor c = db.rawQuery(
            "SELECT * FROM " + TABLE_NAME + " WHERE id1 = ? AND id2 = ?",
            new String[]{String.valueOf(id1), String.valueOf(id2)}
    );
    boolean result = c.getCount() > 0;
    c.close();
    return result;
}