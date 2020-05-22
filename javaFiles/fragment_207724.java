public int ExecuteScalar(/* code...*/) {
    Cursor cursor = database.rawQuery(sql, selectionArgs);
    try {
        cursor.moveToNext();
        int val = cursor.getInt(0);
        cursor.close();
        return val;
    }   
    catch (Exception e) {
        /* code...*/
    }
    return -1;
}