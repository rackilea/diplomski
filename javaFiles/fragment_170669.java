JSONObject obj= new JSONObject(json_string_response);
JSONArray array=obj.getJSONArray("response")
 jObject = array.getJSONObject("current_observation");

    weather = jObject.getString("weather");
    temperature_string = jObject.getString("temperature_string");
   String icon_url = jObject.getString("icon_url");