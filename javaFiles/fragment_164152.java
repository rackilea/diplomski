public ArrayList<String> myArrayListTodatabase() {
    myArraylist.clear();
    db = openOrCreateDatabase("messages", MODE_PRIVATE, null);
    db.rawQuery("Select * from message", null);
    Cursor c = db.rawQuery("Select * from message", null);
    String dbString = "";
    while (c.moveToNext()) {
        if (!c.getString(c.getColumnIndex("msg")).equals("")) {
            myArraylist.add(c.getString(c.getColumnIndex("msg")));
        }
    }
    c.close();
    db.close();
    return myArraylist;
}