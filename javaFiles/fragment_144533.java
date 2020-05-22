public void printAllActivities() {
    SQLiteDatabase database = this.getWritableDatabase();
    System.out.println(database.getPath());

    Cursor c = database.rawQuery("select * from sport", null);
    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
        int index = c.getColumnIndex("activity");
        String activity = c.getString(index);
        System.out.println("activity from database: " + activity);            

    }
    c.close();
    database.close();
}