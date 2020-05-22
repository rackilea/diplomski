sql = "SELECT * FROM EMAIL WHERE TYPE = ?";
  if(haveId) 
    sql += " AND id=?";
  st = createPreparedStatement(sql);
  st.setString(1,type);  
  if(haveId) 
     st.setString(2,id);