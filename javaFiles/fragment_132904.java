Cursor cur = db.rawQuery("SELECT COUNT(*) FROM CAT_BUD_TAB", null);
if (cur != null) {
    cur.moveToFirst();                       // Always one row returned.
    if (cur.getInt (0) == 0) {               // Zero count means empty table.
        for (int i = 0; i < 13; i++) {
            db.execSQL (catInsertArray[i]);
        }
    }
}