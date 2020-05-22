Cursor cursor = getContentResolver().query(
    uri,  
    projection,                       
    selectionClause                   
    selectionArgs,                    
    sortOrder);   

while (cursor.moveToNext ()){
    arrayList.add(cursor.getAsString(cursor.getColumnIndex('column_name')));
}
cursor.close()