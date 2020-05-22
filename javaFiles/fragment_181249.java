JSONObject jo = new JSONObject();
Connection conn = DB.getConnection();
ResultSet rs;
PreparedStatement ps = conn.prepareStatement("select city,state from zips limit 2");
rs = ps.executeQuery();
JSONArray ja = new JSONArray();
while (rs.next()) {
    jo.put("city", rs.getString("city"));
    jo.put("state", rs.getString("state"));
    ja.put(jo);
}

JSONObject mainObj = new JSONObject();
mainObj.put("locations", ja);