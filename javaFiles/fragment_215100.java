SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
String startTime = sdf.format(new Date(System.currentTimeMillis()));
String endTime = sdf2.format(new Date(System.currentTimeMillis()));

PreparedStatement pstmt = conn.prepareStatement( 
 "SELECT * FROM some_table " + 
 "WHERE update_time " + 
  "BETWEEN (CAST(TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP) AT TIME ZONE 'UTC') " + 
    "AND (CAST(TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS') AS TIMESTAMP) AT TIME ZONE 'UTC')");
pstmt.setString(1, startTime);
pstmt.setString(2, endTime);
ResultSet rs = pstmt.executeQuery();