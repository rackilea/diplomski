public Usuario getLastUsuarios() {
    String query = "SELECT    *  FROM  " + TABELA_USUARIOS + " ORDER BY id DESC";
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(query, null);
    if (cursor.moveToFirst()) {
        return cursorToUsuario(cursor);
    }

    // not found.
    return null;
}