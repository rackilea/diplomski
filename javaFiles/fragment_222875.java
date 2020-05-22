SQLiteDatabase db = this.getReadableDatabase();
Cursor cursor = db.query(IME_TABELE, new String[]{ID, PITANJE, PRVI_NETACAN, DRUGI_NETACAN, TRECI_NETACAN, TACAN_ODGOVOR}, ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
podaciOPitanjima podaci = null;
if (cursor.moveToFirst()) {
    //Note: using getColumnIndex avoids errors if the columns are ever returned in a changed order
    podaci = new podaciOPitanjima(
         cursor.getInteger( cursor.getColumnIndex(ID) ), 
         cursor.getString( cursor.getColumnIndex(PITANJE) ), 
         cursor.getString( cursor.getColumnIndex(PRVI_NETACAN) ), 
         cursor.getString( cursor.getColumnIndex(DRUGI_NETACAN) ), 
         cursor.getString( cursor.getColumnIndex(TRECI_NETACAN) ), 
         cursor.getString( cursor.getColumnIndex(TACAN_ODGOVOR) ));
}
return podaci;