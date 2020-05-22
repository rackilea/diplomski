keysOfJson.clear();
 Iterator<String> iterator = jsonObject.keys();
 while (iterator.hasNext()) {
     String key = iterator.next();
     if (jsonObject.get(key) instanceof JSONObject ) {
         JSONObject object= jsonObject.getJSONObject(key);
         if (!keysOfJson.contains(key)) {
             keysOfJson.add(key);
             }
         }
     }