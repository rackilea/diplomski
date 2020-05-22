public List<DataModel> getdata(){
    List<DataModel> data = new ArrayList<>();
    SQLiteDatabase db = this.getWritableDatabase();
    try (Cursor cursor = db.rawQuery("select * from "+TABLE+" ;", null)) {
        int nameIdx = cursor.getColumnIndexOrThrow("name");
        int cityIdx = cursor.getColumnIndexOrThrow("city");
        int countryIdx = cursor.getColumnIndexOrThrow("country");
        while (cursor.moveToNext()) {
            DataModel dataModel = new DataModel();
            dataModel.setName(cursor.getString(nameIdx));
            dataModel.setCity(cursor.getString(cityIdx));
            dataModel.setCountry(cursor.getString(countryIdx));
            data.add(dataModel);
        }
    }
    Log.i("Hello", data.toString());
    return data;
}