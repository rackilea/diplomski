public void getHashMap() {
    int value = 0;
    String key = "";
    Iterator myVeryOwnIterator = mHashMap.keySet().iterator();
    while(myVeryOwnIterator.hasNext()) {

        key=(String)myVeryOwnIterator.next();
        value= mHashMap.get(key);
        Log.d("", "Retrieving value "+key+value);

    }
}