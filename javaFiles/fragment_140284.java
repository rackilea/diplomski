while(rs.next())
{
    JSONObject obj=new JSONObject();
    obj.put("PersonId", rs.getString("id"));
    obj.put("Name", rs.getString("name"));
    obj.put("Age", rs.getString("age"));
    obj.put("RecordDate", rs.getString("date"));

    list.add(obj);
}

//Include this code beneath to create the JSON you require (mainObject).
JSONObject mainObject = new JSONObject();
mainObject.put("Result", "OK");
mainObject.put("Records", list);