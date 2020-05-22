List<String> distancearray = new ArrayList<String>();
Cursor cursor =  dbManager.totaldistance();
do{
    distancearray.add(cursor.getString(cursor.getColumnIndex("distance")));
}while ((cursor.moveToNext()));

// Be sure here to have at least the 5 desired elements into the list
while(distancearray.size() < 5){
    distancearray.add("0");
}