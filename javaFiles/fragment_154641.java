JSONObject weatherArray = new JSONObject(result);
    JSONArray wArray = weatherArray.getJSONArray("weather");
    JSONObject jobj = wArray.getJSONObject(0);
    String mainWeather = jobj.getString("main");
    String mainDescription = jobj.getString("description");
    Toast.makeText(getBaseContext(), mainWeather + " - "
                                + mainDescription,Toast.LENGTH_SHORT).show();