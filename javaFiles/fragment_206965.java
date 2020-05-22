JSONObject obj = new JSONObject();
JSONArray list = new JSONArray();
while(rs.next()) {
    final JSONObject obj1 = new JSONObject();
    obj1.put("source", rs.getString("source"));
    obj1.put("target", rs.getString("target"));
    obj1.put("frequency", rs.getInt("frequency"));
    list.add(obj1);
}