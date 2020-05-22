for(int k=0;k<songs.length();k++){
  JSONObject songObject = songs.getJSONObject(k);
  mObject = new MyObject() // -> NOW you are assigning values to a different instance.
  //mName.add(songObject.getString("name"));
  mObject.setmName(songObject.getString("name"));
  //mURL .add(songObject.getString("url"));
  mObject.setmURL(songObject.getString("url"));
  //mListId .add(songObject.getString("id"));
  mObject.setmID(songObject.getString("id"));
  mAlbumList.add(mObject);
}