public HashMap<String, String> getAllStudents()
{
  Map<String, String> mapStudent = new HashMap<String, String>();
  SQLiteDatabase db = this.getReadableDatabase();
  Cursor res =  db.rawQuery( "select * from "+ TABLE_STUDENTS, null );
  res.moveToFirst();
  while(res.isAfterLast() == false)
  {
    mapStudent.put(res.getString(res.getColumnIndex(ST_ID)) ,res.getString(res.getColumnIndex(ST_SURNAME)) + " , " + res.getString(res.getColumnIndex(ST_FIRST_NAME))); //+ ", " +ST_FIRST_NAME )));
    res.moveToNext();
 }
 return mapStudent;
}