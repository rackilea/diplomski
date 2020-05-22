JSONObject object = new JSONObject(result);
    JSONObject obj1 = object.getJSONObject("query");
    JSONObject obj2 = obj1.getJSONObject("pages");
    JSONObject obj3=null;
   Iterator<String> keys= obj2.keys();
   while (keys.hasNext()) 
  {
        String keyValue = (String)keys.next();
        obj3 = obj2.getJSONObject(keyValue);
  }

    String desc = obj3.getString("extract");