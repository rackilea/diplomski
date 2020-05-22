ArrayList<String> mArrayList = new ArrayList<String>(); 
c.moveToFirst(); 
while(!c.isAfterLast()) { 
     mArrayList.add(c.getString(c.getColumnIndex(DataBaseHelper.KEY_NAME)); 
     c.moveToNext(); 
}