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