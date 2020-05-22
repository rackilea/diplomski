// to get all data from Detail and Record tables
public List<RecDet> getAll()
{
    List<RecDet> listRecDet = new ArrayList<RecDet>();

    // Select All Query
    String selectQuery =
        "SELECT Details.name, Record.rname FROM Detail INNER JOIN Record " +
        "ON Record.conrid = Detail.rid";

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor != null && cursor.moveToFirst())
    {
        do
        {
            RecDet recdet = new RecDet();
            recdet.setName(cursor.getString(cursor.getColumnIndex("name")));
            recdet.setRname(cursor.getString(cursor.getColumnIndex("rname")));
            listRecDet.add(recdet);
        } while (cursor.moveToNext());
    }
    return listRecDet;
}