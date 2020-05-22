public class MySqlHelper extends SQLiteOpenHelper {
    static MySqlHelper mInstance = null;
    static SQLiteDatabase mDatabase = null;

    public static MySqlHelper getInstance() {
        if (mInstance == null) {
            // call private constructor
            mInstance = new MySqlHelper();
        }
        mDatabase = mInstance.getWritableDatabase();
        while(mDatabase.isDbLockedByCurrentThread() || mDatabase.isDbLockedByOtherThreads()) {
            // loop until available
        }
        return mInstance;
    }

    private MySqlHelper() {
        // mContext here is just a placeholder for your ApplicationContext
        // that you should have available to this class.
        super(mContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // all other filled out methods like onCreate, onUpgrade, etc
}