public long insertPlayer(String Username, String Password, String Email)
{
    ContentValues values = new ContentValues();
    values.put("USERNAME", Username);
    values.put("PASSWORD", Password);
    values.put("EMAIL", Email);

    return db.insertWithOnConflict(Table name, null, values, SQLiteDatabase.CONFLICT_IGNORE);  

}