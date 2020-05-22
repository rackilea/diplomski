public String getVotesCount(String eventtitle)
{
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res=db.rawQuery("select VOTESCOUNT from "+TABLE_NAME+" where EVENTTITLE='"+eventtitle+"'",null);

    String votes_count = null;
    if (res.moveToFirst()) {
         votes_count =res.getString(0);
    }
    res.close();
    return votes_count;
}