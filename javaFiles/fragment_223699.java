JSONArray elements  = new JSONArray();
JSONObject rootJson = new JSONObject();
String selectStr    = "select * from emp";
try
{
    JSONArray elements  = null; // to prevent query returning empty resultset
    JSONArray el        = new JSONArray();

    ResultSet rs = ps.executeQuery();
    while(rs.next())
    {
        JSONObject el = new JSONObject();
        el.put("id", rs.getInt(1));
        el.put("name", rs.getString(2));
        elements.put(element);
    }

    rootJson.put("jsonName", elements);

}catch(Exception e)
{
    e.printStackTrace();
}