@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    db.execSQL(
            "create table bookmarks " +
                    "(id integer primary key, dbtitle text)"
    );
}