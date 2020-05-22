// Table name
public static final String TABLE = "feeds";

// Columns
public static final String TIME = "time";
public static final String TITLE = "title";

@Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE + "( " + BaseColumns._ID
                + " integer primary key autoincrement, " + TIME + " integer, "
                + TITLE + " text not null);";
        Log.d("EventsData", "onCreate: " + sql);
        db.execSQL(sql);
    }