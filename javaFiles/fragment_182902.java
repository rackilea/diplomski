try {
     if (json != null)
       return new JSONArray(json);
  } catch (JSONException e) {
     Log.e("JSON Parser", "Error parsing data " + e.toString());
  }