public static abstract class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(Context context, String name, CursorFactory factory) {
        super(context, name, factory, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createAllTables(db, false);
    }
}

/** WARNING: Drops all table on Upgrade! Use only during development. */
public static class DevOpenHelper extends OpenHelper {
    public DevOpenHelper(Context context, String name, CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropAllTables(db, true);
        onCreate(db);
    }
}