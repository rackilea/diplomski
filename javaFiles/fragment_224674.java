public boolean addDetails(String status,String roomValue){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();

            values.put(KEY_STATUS,status);
            values.put(KEY_ROOMVALUE,roomValue);

            db.insert(TABLE_NAME,null,values);
            db.close();
            return true;
        }
public List<String> getAllDetail(){
        List<String> detailList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        String status,roomValue;
        if(cursor.moveToFirst()){
            do{
                status=cursor.getString(cursor.getColumnIndex(KEY_STATUS));
                roomValue=cursor.getString(cursor.getColumnIndex(KEY_ROOMVALUE));


                detailList.add(status);
                detailList.add(roomValue);
            }while (cursor.moveToNext());
        }
        return detailList;
    }