private void insertSpot(SQLiteDatabase db, String name, String address, String note, String rank) {
    ContentValues content = new ContentValues();
    content.put("NAME", name);
    content.put("ADDRESS", address);
    content.put("NOTE", note);
    content.put("RANK", rank);
    db.insert("SPOT", null, content);
}