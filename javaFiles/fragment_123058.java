ArrayList<String> nameList = new ArrayList<String>();
    String[] projection = {"name"};
    String selection = null;
    String[] selectionArgs = null;
    String sort = null;
    resolver = getContentResolver();
    cursor = resolver.query(uri, projection, selection, selectionArgs, sort);
    Log.i("TUTORIAL", "counts :"+cursor.getCount());    
    String s;
    if(cursor.moveToFirst()) {
        do {
            nameList.add(cursor.getString(0));
            //your code
            //s = cursor.getString(x);
            Log.i("TUTORIAL", ""+cursor.getString(0));
        }while(cursor.moveToNext());
    }