private static DatabaseHelper sInstance = null;

public static synchronized DatabaseHelper getInstance(Context context) {

    if (sInstance == null) {
        sInstance = new DatabaseHelper(context.getApplicationContext());
    }
    return sInstance;
 }

private DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}