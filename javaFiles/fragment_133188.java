JSONObject hi = new JSONObject(test);
JSONArray stuff = hi.getJSONArray("employees");         
JSONObject name = stuff.getJSONObject(0);
String[] items = new String[hi.length()];
items[0]=name.getString("firstName");
System.out.println(items[0]);