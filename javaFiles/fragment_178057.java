PreparedStatement getSerial = con.prepareStatement("select max(sr_no) from comm_list"); // "con" is the connection with the database
getSerial.execute();
ResultSet rs = getSerial.getResultSet();
if(rs.next()) {
   srNo = rs.getInt(1) + 1;
}
System.out.println(srNo);