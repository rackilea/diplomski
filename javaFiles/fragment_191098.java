Map<String, Object> map = new HashMap<>();

JSONParser parser = new JSONParser();

try {

  Object obj = parser.parse(list);

  JSONArray jsonArray = (JSONArray)obj;

  Iterator<JSONObject> iterator = jsonArray.iterator();
  while (iterator.hasNext()) {
       JSONObject jsonObj = iterator.next();
      String name = (String) jsonObject.get("name");
       Object content = (Object) jsonObject.get("content");
       map.put(name, content);
  }
} catch (ParseException p) { }