JSONObject obj = new JSONObject();
JSONObject obj1 = new JSONObject();
JSONArray list = new JSONArray();
while(rs.next()){
    obj1.put("source", rs.getString("source"));
    obj1.put("target", rs.getString("target"));
    obj1.put("frequency", rs.getInt("frequency"));
    list.add(obj1);
}