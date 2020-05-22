JSONObject forecast = new JSONObject(jsonData);
JSONArray list = currentForecast.getJSONArray("list");

Current currents = new Current();
for(int i = 0; i < list.length(); i++){

    JSONObject Info = list.getJSONObject(i);
    JSONObject temp = Info.getJSONObject("main");

    double dub = temp.getDouble("temp");

    // "dt_txt" is at the top level of the node
    String time = Info.getString("dt_txt");

    //geteverything after the last space
    String sub = time.substring(time.lastIndexOf(' ') + 1);

    //test for 12:00:00 on time string
    // only put in currents if it is 12:00:00

    if(sub.equals("12:00:00") {
        currents.setTemp(dub));
    }