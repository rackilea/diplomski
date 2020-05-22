private void jsonRead(String file) throws JSONException {
    JSONObject root=new JSONObject(file);
    JSONArray jsonArray = root.optJSONArray("weather");
    JSONObject jo2=root.optJSONObject("main");
    for(int i=0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        dama.setText(jsonObject.getString("description"));
    }
    rotobat.setText(jo2.getString("humidity"));
}