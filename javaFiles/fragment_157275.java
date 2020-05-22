if(myCursor.getCount()==0){
// contains nothing so show some message to user
return;
}
else {
ArrayList<Integer> mylist = new ArrayList<Integer>;
// 
while(myCursor.moveToNext()){
// dont need first column if we use loop for arraylist
//mylist.add(myCursor.getInt(cursor.getColumnIndex("COL_1")));
mylist.add(myCursor.getInt(cursor.getColumnIndex("COL_2")));
}