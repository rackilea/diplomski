/**
 * Simple Delegate for SQLiteDatabase
 */
public class SQLiteChecker {
    private final SQLiteDatabase mDbDelegate;
    public SQLiteChecker(SQLiteDatabase db) {
        mDbDelegate = db;
    }
    // ------------ Delegate methods --------------------//
    public int delete(String table, String whereClause, String[] whereArgs) {
        checkSQL(whereClause, whereArgs);
        return mDbDelegate.delete(table, whereClause, whereArgs);
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        checkSQL(whereClause, whereArgs);
        return mDbDelegate.update(table, values, whereClause, whereArgs);
    }

    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        checkSQL(sql, bindArgs);
        mDbDelegate.execSQL(sql, bindArgs);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        checkSQL(sql, selectionArgs);
        return mDbDelegate.rawQuery(sql, selectionArgs);
    }

    // add more if you need

    // -------------- checking logic -------------------//
    private static void checkSQL(String query, Object[] args) {
        // bit unreliable but simple:
        // just check if amount of ? matches args.length
        int expected = countChar(query, '?');
        int actual = args != null ? args.length : 0;
        if (expected != actual) {
            Log.e("CHECK", "You seem to have messed up [" + query + "]");
            Log.e("CHECK", "expected:" + expected + " actual:" + actual);
        }
    }

    private static int countChar(String string, char ch) {
        if (string == null) return 0;
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ch)
                count++;
        }
        return count;
    }
}