DatabaseHandler dbz = new DatabaseHandler(Activity.this);

public Context context;

public DatabaseHandler(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    // assigning context Change your constructor
    this.context = context;
}

// Open database using context object
SQLiteDatabase db = this.getReadableDatabase();