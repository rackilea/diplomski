JSONObject myResponse = new JSONObject(response.toString());
JSONArray jrr= myResponse.getJSONArray("weather");
System.out.println("CITY-"+myResponse.getString("name"));
JSONObject weatherObj = jrr.getJSONObject(0);
String desc = weatherObj.getString("description");
System.out.println(desc);