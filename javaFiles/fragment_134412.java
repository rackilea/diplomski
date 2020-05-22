public Cursor queryAll(){
        //get a READABLE database instance:
        SQLiteDatabase db = dbRequery.getReadableDatabase();

        //query all:
        //db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        Cursor cursor = db.query(
                dbVariablesCreate.TaskEntry.TABLE,null,
                null,
                null,
                null,
                null,
             null );
        return cursor ;
    }