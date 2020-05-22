public class PostsDatabaseHelper extends SQLiteOpenHelper { 
  private static PostsDatabaseHelper sInstance;

  // ...

  public static synchronized PostsDatabaseHelper getInstance(Context context) {
    // Use the application context, which will ensure that you 
    // don't accidentally leak an Activity's context.
    if (sInstance == null) {
      sInstance = new PostsDatabaseHelper(context.getApplicationContext());
    }
    return sInstance;
  }

  /**
   * Constructor should be private to prevent direct instantiation.
   * Make a call to the static method "getInstance()" instead.
   */
  private PostsDatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
}