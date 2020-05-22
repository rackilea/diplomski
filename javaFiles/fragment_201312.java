public void sampleMethod(String[] arguments) {
    ContentValues values = new ContentValues();
    values.put("Column1", arguments[0]);
    values.put("Column2", arguments[1]);
    values.put("Column3", arguments[2]);
    ....
    db.insert(TABLE_NAME, null, values);
}