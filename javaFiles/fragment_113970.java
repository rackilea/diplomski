private boolean checkDataBase()
{
    File dbFile = new File(DB_PATH + DB_NAME);
    //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
    return dbFile.exists();
}