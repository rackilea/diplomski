@Override
public void onChildAdded(DataSnapshot dataSnapshot, String s) {

    //add keys to arraylist
    String key=dataSnapshot.getKey();
    arraylist.add(key);

    if (arraylist.size() == 3){
       Log.i("Key: " arraylist.get(2), "Index: 2");
    }
}