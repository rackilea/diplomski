String query = "update ENV_MOTS_DETAILS set " +
        "ENV_NAME= ? , CONSOLE_URL= ? , REMOTE_NODE= ? , CONSOLE_TO_LOGON=? , " +
        "REGION=? , DELETE_FLAG='Y' , ADMIN_PWD=? , " +
        "COMPONENT='' , COMMENTS='' , LAST_UPDATED_BY=?, " +
        "LAST_UPDATED_ON=to_date(to_char(SYSDATE,'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') WHERE ENV_ID = ?";

try(Connection con = db.getConnection();      
     ps = con.prepareStatement(query)) {
  log.info("[Editconsole Method Call Query]"+query);

  ps.setString(1,env);
  ps.setString(2,url);
  ps.setString(3,rnode);
  ps.setString(4,user);
  ps.setString(5,region);
  ps.setString(6,password);
  ps.setString(7,attuid);
  ps.setInt(8,envid);

  int numAffected = ps.executeUpdate();
  log.info("Statement affected " + numAffected + " rows");
  return 1; //Worked.

 } 
 catch (Exception e)  {
    log.fatal("[SQL Exception in Retreving Server Details]"+e.getMessage());
 }
 return 0;
}