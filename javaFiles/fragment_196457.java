String data = "{ ... }";
Object json = new JSONTokener(data).nextValue();
if (json instanceof JSONObject)
  //you have an object
else if (json instanceof JSONArray)
  //you have an array