public Cursor getItemID(String name){
    SQLiteDatabase db = this.getWritableDatabase();
    String query="SELECT"+ COL1 +" FROM "+TABLE_NAME+" WHERE "+COL2+ " = '" + name + " ' ";
    Cursor data = db.rawQuery(query,null);
    return data;
}