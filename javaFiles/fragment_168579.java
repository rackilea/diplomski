public String findBus(String sourcename, String desname){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor mCount= db.rawQuery("select count(*) from search_table where name='" + sourcename + "' AND dname='"+desname+"'", null);
    mCount.moveToFirst();
    String src= mCount.getString(0); //<<<< Changed offset to 0 from 1
    mCount.close();
    return src;
}