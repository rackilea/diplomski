Map<String,JSONArray> map=new HashMap<>();
for(int i=0;i<jArr.length();i++){
  JSONObject object=(JSONObject)jArr.get(i);
  for(Iterator<String> it=object.keys();it.hasNext();){
    String key=it.next();
    if(!map.containsKey(key)){//This initializes the array on first element
      map.put(key, new JSONArray());
    }
    //This fetches the array corresponding to the member's name from the map
    JSONArray array=map.get(key);
    //put the member's value into the array
    array.put(object.get(key));
  }
}