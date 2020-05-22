JSONObject json = new JSONObject();
Set<String> keys = bundle.keySet();
for (String key : keys) {
   try {
       json.put(key, bundle.get(key)); 
   } catch (JSONException e) {
       e.printStackTrace();
   }
}