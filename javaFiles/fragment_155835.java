JSONObject obj;
JSONArray list = new JSONArray();

while(rs.next()){
    obj=new JSONObject();
    list.add(obj);
    obj.put("id", new Integer(rs.getInt("id")));
    obj.put("description", rs.getString("description"));
    obj.put("libelle", rs.getString("libelle"));
    obj.put("ordre", new Integer(rs.getInt("ordre")));
    obj.put("warning", new Boolean(rs.getBoolean("warning")));
}
out.print(list);
out.flush();