Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

if (c.moveToFirst()) {
    while ( !c.isAfterLast() ) {
        Toast.makeText(activityName.this, "Table Name=> "+c.getString(0), Toast.LENGTH_LONG).show();
        c.moveToNext();
    }
}