for(int i=0; i < jsonarray.length(); i++) {
    JSONObject jsonobject = jsonarray.getJSONObject(i);
    String id       = jsonobject.getString("id");
    String title    = jsonobject.getString("title");
    String company  = jsonobject.getString("company");
    String category = jsonobject.getString("category");
}