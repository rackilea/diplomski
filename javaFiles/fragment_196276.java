public Gljive getGljiveById(int id) {
    Gljive gljive = null;

    SQLiteDatabase db = getReadableDatabase();

    Cursor cursor = db.query(
            TABLE_GLJIVE, null, COLUMN_ID + "=?", //<<<< =? 
            new String[]{String.valueOf(id)},     //<<<< uses the passed id
            null, null, orderBy);
    if (cursor.moveToFirst()) {                   //<<<<< cursor will not be null
        gljive = cursorToGljive(cursor);
        cursor.close();
    }

    return gljive;
}

public Gljive getGljiveByNaziv(String Naziv) {
    Gljive gljive = null;

    SQLiteDatabase db = getReadableDatabase();

    Cursor cursor = db.query(
            TABLE_GLJIVE, null, COLUMN_NAZIV + "=?", //<<<< =?
            new String[]{Naziv},                     //<<<< use passed Naziv as argument
            null, null, null);
    if (cursor.moveToFirst()) {                      //<<<< cursor never null         
        gljive = cursorToGljive(cursor);
        cursor.close();
    }

    return gljive;
}

public List<Gljive> getGljiveByKBoja(String Klobuk_Boja) {
    List<Gljive> gljive = new ArrayList<>();
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(
            TABLE_GLJIVE, null, COLUMN_KBOJA + "=?",  //<<<< =?
            new String[]{Klobuk_Boja},                //<<<< use passed value as argument 
            null, null, orderBy);
    while (cursor.moveToNext()) {                     // compact loop removed null check
        gljive.add(cursorToGljive(cursor))            // add Gljive object to List
    }
    cursor.close();
    return gljive;
}