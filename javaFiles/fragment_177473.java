public void onCreate(SQLiteDatabase db)
{
    db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
        ...);
    db.execSQL("INSERT INTO " + DATABASE_TABLE + " DEFAULT VALUES");
}