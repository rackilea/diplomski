private boolean isValidJsonResponse(String responseString){
    try {
        new JSONObject(responseString);
        return true;
    } catch(JSONException e) {
        return false;
    }
  }