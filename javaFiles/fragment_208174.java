try {
        JSONObject obj = new JSONObject(result);
        JSONObject stoker = obj.getJSONObject("stoker");
        JSONArray jArray = stoker.getJSONArray("sensors");
        for(int i = 0; i < jArray.length(); i++) {
            JSONObject json_data = jArray.getJSONObject(i);
            Sensor resultRow = new Sensor();
            resultRow.id = json_data.getString("id");
            resultRow.name = json_data.getString("name");
            resultRow.current = json_data.getDouble("tc");
            resultRow.target = json_data.getInt("ta");
            arrayOfWebData.add(resultRow);
        }
    }
    catch(JSONException e){
        Log.e("log_tag", "Error parsing data "+e.toString());
    }