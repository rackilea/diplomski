class DbInsert {

    final SQLiteDatabase db = (new DbHelper(this)).getWritableDatabase();
    ContentValues values;

    public DbInsert(Context ctx) {
        db = (new DbHelper(ctx)).getWritableDatabase();

        values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_EN_WORD, "add");
        //.... etc...
    } 
}