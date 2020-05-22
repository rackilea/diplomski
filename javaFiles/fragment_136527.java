JSONObject obj = new JSONObject("first json");
 JSONObject obj2 = new JSONObject("second json");
 Iterator<String> keys = obj2.keys();
 while( keys.hasNext() ) {
     String key =  keys.next();
     obj.put(key, obj2.optString(key);
 }