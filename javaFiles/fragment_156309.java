JSONArray arr = new JSONArray(response);
//or
//JSONArray arr = yourJsonObject.getJSONArray("name");


String add = arr.optString(0);