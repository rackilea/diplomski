Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
List<String> tableList = new ArrayList<>();

if (c.moveToFirst()) {
    while (!c.isAfterLast()) {
        tableList.add(c.getString(0));
        c.moveToNext();
    }
}