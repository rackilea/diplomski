public JSONArray cur2Json(Cursor cursor) {

JSONArray resultSet = new JSONArray();
cursor.moveToFirst();
while (cursor.isAfterLast() == false) {
    int totalColumn = cursor.getColumnCount();
    JSONObject rowObject = new JSONObject();   
    for (int i = 0; i < totalColumn; i++) {
        if (cursor.getColumnName(i) != null) {
            try {
                rowObject.put(cursor.getColumnName(i),
                        cursor.getString(i));
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
    }
    resultSet.put(rowObject);
    cursor.moveToNext();
}

cursor.close();
return resultSet;

    }