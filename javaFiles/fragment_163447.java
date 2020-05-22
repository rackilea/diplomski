Your method should look like this :

public ArrayList<String> getRecords(){
    ArrayList<String> data=new ArrayList<String>();
    Cursor cursor = db.query(DATABASE_TABLE, new String[]{"column names"},null, null, null, null, null);
    String fieldToAdd=null;
    while(cursor.moveToNext()){
       fieldToAdd=cursor.getString(0);
       data.add(fieldToAdd);
    }
    cursor.close();  // dont forget to close the cursor after operation done
    return data;
}

this method will return all field values from database to arraylist