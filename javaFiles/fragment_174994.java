try {
   JSONTokener json = new JSONTokener(stringToJsonify);
   JSONObject object = json.getJSONObject("test");
} catch (JSONException e){
   onJsonException();
}