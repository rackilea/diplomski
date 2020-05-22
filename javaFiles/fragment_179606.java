try {
      JSONObject root = new JSONObject(result);
      username = root.getString("Username");
      password = root.getString("Password");
   } catch (JSONException e) {
      Log.e("log_tag", "Error parsing data "+e.toString());
   }