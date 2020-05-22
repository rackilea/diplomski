public void delete(int orderInList){//orederInList is the position in your listView
                    SQLiteDatabase db = this.getWritableDatabase();
                    List<Integer> database_ids = new ArrayList<Integer>();
                    Cursor c = db.rawQuery("SELECT*FROM "+TABLE_HABITS,null);
                    while(c.moveToNext){
                    database_ids.add(Integer.parseInt(c.getString(0)));
                    }
                    db.delete(TABLE_HABITS,KEY_ID + " =?",new String[]{String.valueOf(database_ids.get(orderInList)});