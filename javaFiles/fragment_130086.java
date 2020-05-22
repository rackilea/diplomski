while(rs.next()){
    //new line:
    JSONObject Obj = new JSONObject();
    // original part looks fine:
    Obj.put("uname",rs.getString("uname").trim());
    Obj.put("comment",rs.getString("comments").trim());
    CommArray.add(Obj);
}