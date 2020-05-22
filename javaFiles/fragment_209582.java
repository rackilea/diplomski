JSONObject object = new JSONObject(message);
Iterator<String> keyList = object.keys();

while (keyList.hasNext()){
     String key = keyList.next();
     object.get(key);
     //parse value and use it

}