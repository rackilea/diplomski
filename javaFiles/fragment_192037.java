Cursor c = db.rawQuery("SELECT * FROM table WHERE 0", null);
try {
    String[] columnNames = c.columnNames();
} finally {
    c.close();
}