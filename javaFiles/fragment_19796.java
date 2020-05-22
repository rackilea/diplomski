Cursor ti = db.rawQuery("PRAGMA table_info(mytable)", null);
if ( ti.moveToFirst() ) {
    do {
        System.out.println("col: " + ti.getString(1));
    } while (ti.moveToNext());
}