public JSONArray getJsonData() throws JSONException {
  JSONArray jsonarray = new JSONArray();
  BasicDBObject criteria = new BasicDBObject();
  BasicDBObject projections = new BasicDBObject();
  criteria.put("Address", "Mumbai");
  projections.put("_id", 0);
  projections.put("Incident Date", 1);
  projections.put("Longitude", 1);
  projections.put("Latitude", 1);
  projections.put("Address", 1);
  projections.put("Status", 1);
  projections.put("Name", 1);
  DBCursor cursor = coll.find(criteria, projections);
  while(cursor.hasNext()) {
    BasicDBObject obj = (BasicDBObject) cursor.next();
    jsonobj = new JSONObject();
    BasicDBList name = (BasicDBList) obj.get("Name");
    jsonobj.put("Incident Date", obj.getString("Incident Date"));
    jsonobj.put("Longitude", obj.getString("Longitude"));
    jsonobj.put("Latitude", obj.getString("Latitude"));
    jsonobj.put("Address", obj.getString("Address"));
    jsonobj.put("Status", obj.getString("Status"));
    jsonobj.put("Name", name);
    jsonarray.put(jsonobj);
  }
  return jsonarray;
}