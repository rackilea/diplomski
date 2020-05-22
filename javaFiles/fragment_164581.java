SQLiteDatabase db = null;
DBHandler dd = new DBHandler(getBaseContext());
dd.getWritableDatabase();
db= openOrCreateDatabase("profileManager.db", Context.MODE_PRIVATE, null);
Cursor cc = db.rawQuery("SELECT * FROM profile", null);
if(cc.getCount()>=1) {
    cc.moveToFirst();
    try {
        for(int i=0;i < cc.getCount();i++){
            bname = cc.getString(1);
            btype = cc.getString(2);
            bmail = cc.getString(3);
            bphone = cc.getString(4);
            baddress = cc.getString(5);
            bpackage = cc.getString(6);
        }
    }catch (Exception e){
        e.getMessage();
    }
}