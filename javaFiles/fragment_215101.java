PreparedStatement pstmt = conn.prepareStatement( 
 "SELECT TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') test1 " +
   "CAST(TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP) test2 " +
   "(CAST(TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP) AT TIME ZONE 'UTC') test3 " +
 "FROM some_table " + 
 "WHERE update_time " + 
  "BETWEEN TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') " +  => In test, this is not important
    "AND TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') ");  => In test, this is not important
pstmt.setString(1, startTime);
pstmt.setString(2, startTime);
pstmt.setString(3, startTime);
pstmt.setString(4, startTime);
pstmt.setString(5, endTime);
ResultSet rs = pstmt.executeQuery();

System.out.println(rs.getString("test1") + "/" +rs.getString("test2") + "/" + rs.getString("test3") );