public ArrayList<YourObject> getYourObjects(){
    ArrayList<YourObject> yourObject= new ArrayList<YourObject>();

    SQLiteDatabase db=this.getReadableDatabase();
    Cursor cur=db.rawQuery("YOUR QUERY",new String [] {});
    for(int i = 0; i<cur.getCount(); i++){
        cur.moveToPosition(i);      
        String string.setTimeInMillis(cur.getLong(cur.getColumnIndexOrThrow("YOUR_COLLUMN_NAME")));     
        yourObject.add(new YourObject());
    }
    cur.close();
    db.close();

    return workObjects;
}