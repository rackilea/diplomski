Cursor cursor = db.query("phone", colunas, null, null, null, null,"_id ASC");

while (cursor.moveToNext())
{
    // Do stuff
}