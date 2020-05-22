//Query
    String query = "select COUNT from contacts where name = ?";
    Cursor cursor = db1.rawQuery(query, new String[] {name});
    if(cursor.getCount()<1) // title Not Exist
    {
        cursor.close();
        return 0;
    }
    cursor.moveToFirst();
    int count = cursor.getInt(cursor.getColumnIndex("COUNT"));
    cursor.close();
    return count;