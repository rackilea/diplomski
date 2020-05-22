try{
  JSONArray json = uf.getAllRows();
  (int x = 0; x <= json.length(); x++) {
  JSONObject jo = json.getJSONObject(x); //Eclipse is suggesting that use try-catch here.

  String name = jo.getString("username");
  mainll[x] = new LinearLayout(this);
  mainll[x].setId(x);
  mainll[x].setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
  mainll[x].setGravity(Gravity.CENTER);
}
catch(Exception e){}