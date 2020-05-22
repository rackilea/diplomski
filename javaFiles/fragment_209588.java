public class DatabaseHelper extends SQLiteOpenHelper {

...

    public synchronized Cursor getKeywordsCursor (String prefix) {
        if (database == null) database = this.getReadableDatabase();
        String[] columns = {"_id", "keyword"};
        String[] args = {prefix};

        Cursor cursor;
        cursor = database.query("keywords", columns, "keyword like '' || ? || '%'", args, null, null, "keyword", "40");

        int idcol = cursor.getColumnIndexOrThrow("_id");
        int kwcol = cursor.getColumnIndexOrThrow("keyword");

        while(cursor.moveToNext()) {
            int id = cursor.getInt(idcol);
            String kw = cursor.getString(kwcol);
            Log.i("keyword", kw);
        }

        cursor.moveToPosition(-1);
        return cursor;
    }

...

}