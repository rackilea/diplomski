public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "leagueapp.db";
    public static final int DBVERSION = 1;

    SQLiteDatabase mDB;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Bowler.CRTSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertBowler(String leagueId, String bowlerName) {
        //Get Writable Database That We Want To Write Data Too
        SQLiteDatabase db = this.getWritableDatabase();

        Log.d("INSERTBOWLER","Number of bowlers in db = " + String.valueOf(DatabaseUtils.queryNumEntries(db,Bowler.TABLE_NAME)));

        ContentValues values = new ContentValues();
        //`id` and `timestamp` Will Be Inserted Automatically
        values.put(Bowler.COLUMN_LEAGUE_ID, leagueId);
        values.put(Bowler.COLUMN_NAME, bowlerName);

        //Insert Row
        long id = db.insertOrThrow( Bowler.TABLE_NAME, null, values );

        //Close Database Connection
        db.close();

        //Return Newly Inserted Row Id
        return id;
    }

    public Bowler getBowler(String leagueId) {
        //Get Readable Database If We Are Not Inserting Anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Bowler.TABLE_NAME,
                new String[]{Bowler.COLUMN_ID, Bowler.COLUMN_LEAGUE_ID, Bowler.COLUMN_NAME, Bowler.COLUMN_TIMESTAMP},
                Bowler.COLUMN_LEAGUE_ID + "=?",
                new String[]{String.valueOf(leagueId)}, null, null, null, null);

        if (cursor.moveToFirst()) {

            //Prepare Bowler Object
            Bowler bowler = new Bowler(
                    cursor.getLong(cursor.getColumnIndex(Bowler.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_LEAGUE_ID)),
                    cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_TIMESTAMP)));

            //Close Database Connection
            cursor.close();
            return bowler;
        } else {return null;}
    }
    public List<Bowler> getAllBowlers(String leagueId) {
        List<Bowler> bowlers = new ArrayList<>();

        //Select All Query
        String selectQuery = "SELECT  * FROM " + Bowler.TABLE_NAME + " WHERE " + Bowler.COLUMN_LEAGUE_ID + " = '" + leagueId + "'" + " ORDER BY " +
                Bowler.COLUMN_TIMESTAMP + " DESC";

        Log.d("GETALLBOWLERS-SQL","SQL used = >>>>" +selectQuery + "<<<<");

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        Log.d("GETALLBOWLERS-CNT","Number of rows retrieved = " + String.valueOf(cursor.getCount()));


        //Looping Through All Rows And Adding To The List
        if (cursor.moveToFirst()) {
            do {
                Bowler bowler = new Bowler();
                bowler.setId(cursor.getInt(cursor.getColumnIndex(Bowler.COLUMN_ID)));
                bowler.setLeagueId(cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_LEAGUE_ID)));
                bowler.setName(cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_NAME)));
                bowler.setTimestamp(cursor.getString(cursor.getColumnIndex(Bowler.COLUMN_TIMESTAMP)));
                bowlers.add(bowler);
            } while (cursor.moveToNext());
        }
        cursor.close();
        //Close Database Connection
        db.close();
        Log.d("GETALLBOWLERS-CNT","Number of elements in bowlerslist = " + String.valueOf(bowlers.size()));

        //Return Bowlers List
        return bowlers;
    }

    public int getBowlersCount() {
        String countQuery = "SELECT  * FROM " + Bowler.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        //Return The Count
        return count;
    }

    public int updateBowler(Bowler bowler) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Bowler.COLUMN_LEAGUE_ID, bowler.getLeagueId());
        values.put(Bowler.COLUMN_NAME, bowler.getName());

        //Updating Row
        return db.update(Bowler.TABLE_NAME, values, Bowler.COLUMN_ID + " = ?",
                new String[]{String.valueOf(bowler.getId())});
    }

    public void deleteBowler(Bowler bowler) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( Bowler.TABLE_NAME, Bowler.COLUMN_ID + " = ?",
                new String[]{String.valueOf( bowler.getId())});
        db.close();
    }

    public int deleteBowlerChecked(Bowler bowler) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("DELETEBOWLER","Attempting to DELETE bowler " + bowler.getName());
        int rv = db.delete(Bowler.TABLE_NAME,Bowler.COLUMN_ID + "=?",
                new String[]{String.valueOf(bowler.getId())});
        if (rv < 1) {
            Log.d("DELETEBOWLER", "Bowler with an id of " + String.valueOf(bowler.getId()) + " was not deleted, as it didn't exist.");
        }
        return rv;
    }
}