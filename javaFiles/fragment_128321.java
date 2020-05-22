try
    {
        AndroidOpenDbHelper queryDbHelperObj = new AndroidOpenDbHelper(this);
        SQLiteDatabase sqLiteDatabase = queryDbHelperObj.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SQL_SELECT_QUERY,null);

        if(cursor != null)
        {
            if(cursor.moveToFirst())
            {
                do
                {
                    String OriginDB = cursor.getString(cursor.getColumnIndex("Origin"));
                    String DestinationDB = cursor.getString(cursor.getColumnIndex("Destination"));

                }while(cursor.moveToNext());
            }
        }
    }
    catch(Exception err)
    {
        err.printStackTrace();
    }