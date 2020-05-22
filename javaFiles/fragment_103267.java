//getting whole json string
JSONObject jsonObj = new JSONObject(jsonStr);

//extracting data array from json string
JSONArray ja_data = jsonObj.getJSONArray("data");
int length = jsonObj .length();