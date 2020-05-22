JSONObject jsonObject;
    try {
         jsonObject = new JSONObject(message);
         JSONArray jsonArray = jsonObject.getJSONArray(Quake.FEATURES);
         //Continue get remain information 
    } catch (JSONException e) {
         e.printStackTrace();
    }