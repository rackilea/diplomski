public List<Earthquake>getListByDate(LocalDate dateInput){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PUB_DATE + " = " + "'"+dateInput+"'", null);
    Log.e("Cursor", ""+data.getColumnCount());
    List<Earthquake> list = QueryReturnList(data);
    Log.e("QueryReturnList", ""+list);
    return list;
}