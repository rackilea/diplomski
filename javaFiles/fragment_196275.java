private Gljive cursorToGljive(Cursor cursor){
    Gljive gljive= new Gljive(
        cursor.getString(cursor.getColumnIndex(COLUMN_NAZIV)
    );
    gljive.setId(cursor.getColumnIndex(COLUMN_ID)); //Note(1)
    return gljive;
}