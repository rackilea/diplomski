public JSONObject updateUserGeoLocation(String lon, String lat) {
      // Building Parameters
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      params.add(new BasicNameValuePair("tag", LOCATION_UPDATE_TAG));
      params.add(new BasicNameValuePair("email", email));
      params.add(new BasicNameValuePair("password", password));
      params.add(new BasicNameValuePair("lon", lon));
      params.add(new BasicNameValuePair("lat", lat));
      JSONObject json = jsonParser.getJSONFromUrl(LOCATION_UPDATE_URL, params);
      return json;
   }