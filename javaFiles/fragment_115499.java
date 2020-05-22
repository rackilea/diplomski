public String toString() {
   JSONObject obj = new JSONObject();
   try {
      obj.put("name", name);
      obj.put("desc", desc);
      obj.put("date", date.getTime());
  catch (JSONException e) {
        Log.e(getClass().getSimpleName(), e.toString());
   }
   return obj.toString();
}