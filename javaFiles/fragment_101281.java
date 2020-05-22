public String getStartBal() {
    Cursor cr=ourDatabase.rawQuery("SELECT "+KEY_START_BAL+" FROM "+DB_TABLE,null);
    String sum="";
    for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
        sum=cr.getString(cr.getColumnIndex(KEY_START_BAL));
    }
    cr.close();
    return sum;
}