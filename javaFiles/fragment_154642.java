JSONObject rootJsonObj = new JSONObject(result);
     JSONArray wArray = rootJsonObj.optJSONArray("weather");
     for (int i = 0; i < wArray.length(); i++) {
          JSONObject weatherJsonObj = wArray.getJSONObject(i);
          String mainWeather = weatherJsonObj.getString("main");
          String mainDescription = weatherJsonObj.getString("description");

          Toast.makeText(getBaseContext(), mainWeather + " - "
                      + mainDescription,Toast.LENGTH_SHORT).show();
     }