JSONObject parentObject = new JSONObject(finalJson);
JSONArray deparray = parentObject.getJSONArray("departureList");
for (int i = 0; i < deparray.length(); i++) {
    JSONObject getdep = deparray.getJSONObject(i);
    JSONObject lineobject = getdep.getJSONObject("servingLine");
    String trainnumber = lineobject.getString("number");
}