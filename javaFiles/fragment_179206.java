HashMap<String, String> data = new HashMap<String, String>(); 
data.put("name", "value");
data.put("mykey", "myvalue");

JSONObject json = new JSONObject(data);
String jsonString = json.toString();