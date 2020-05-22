String query = "SELECT MAX(row_id) AS max_id FROM mytable";
Cursor cursor = db.rawQuery(query, null);
int id = 0;     
if (cursor.moveToFirst())
{               
  id = cursor.getInt(0);                         
}