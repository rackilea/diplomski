public ArrayList<String> getAllFriends(int id) {
    ArrayList<String> friendsNames = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase = null;
    try {
        String query = "select * from person P join friends F on F.id = P.id where P.id = " + id;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            friendsNames.add(cursor.getString(cursor.getColumnIndex("allFriends")));
        }
    }catch(Exception ex){
        Log.e(TAG,"Erro in geting friends "+ex.toString());
    }
    return friendsNames;
  }