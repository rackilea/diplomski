try {
      JSONObject object = new JSONObject(new String(response));
      accessToken = object.getString("access_token");
  } catch (JSONException e) {
      e.printStackTrace();
  }