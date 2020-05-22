public class MyDataSource {
    // Database fields
    private final SQLiteDatabase mDatabase;
    private final MySqlHelper mHelper;

    public MyDataSource() {
        mHelper = MySqlHelper.getInstance();
        mDatabase = mHelper.getDatabase();
    }

    // add your custom methods 

    private int update(ContentValues values, String whereClause) {
        int rowsUpdated = 0;
        synchronized (mDatabase) {
            rowsUpdated = mDatabase.update(MySqlHelper.TABLE_NAME, values, whereClause, null);
        }
        return rowsUpdated;
    }

    public int updateById(ContentValues values, int id) {
        final String whereClause = MySqlHelper.COLUMN_ID + "=" + id;
        return this.update(values, whereClause);
    }
}