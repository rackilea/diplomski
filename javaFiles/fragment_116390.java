Cursor cursor = db.rawQuery("SELECT idkliy, kliyentad FROM " + TABLE_KLIYENT, null);
cursor.moveToPosition(0);
while (!cursor.isAfterLast()) {
    linkedHashMap.put(cursor.getString(cursor.getColumnIndex(COLUMN_KLIYENTAD)), cursor.getInt(cursor.getColumnIndex(COLUMN_IDKLIY)));
    cursor.moveToNext();
}
cursor.close();