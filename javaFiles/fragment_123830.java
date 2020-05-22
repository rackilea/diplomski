JSONArray jsonarr = new JSONArray(Data);
for (int i = 0; i < jsonarr.length(); i++) {
    JSONObject jsonobject = jsonarr.getJSONObject(i);
    Test current = new Test(jsonobject.getString("Car"), jsonobject.getString("Color"));
    data.add(current);
}