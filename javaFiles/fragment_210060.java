returnString = "";

JSONObject json_data = new JSONObject(result);
Log.i("log_tag","value:"+json_data.getString("value"));

returnString = json_data.getString("value");