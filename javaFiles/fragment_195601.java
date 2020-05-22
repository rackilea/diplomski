public Usuario getLastUsuario() {
   SQLiteDatabase db = this.getReadableDatabase();
   // get all rows in table.
   Cursor cursor = db.query(TABELA_USUARIOS, null, null, null, null, null, null);

   Usuario usuario = null;
   if (cursor != null) {
     cursor.moveToLast();
     usuario = cursorToUsuario(cursor);
   }

   cursor.close();
   return usuario;
}