int i=0; 
String q="select * from QueryData where id=123456"; 
try (PreparedStatement pstmnt = conn.prepareStatement(q);
     ResultSet rs = pstmnt.executeQuery()) {

     ResultSetMetaData rsmd = rs.getMetaData();

     // Assume it's just one row.
     // If there's more than one, you need a while loop
     if (rs.next()) {
         for (int i = 0; i < rsmd.getColumnCount(); ++i) {
             data.add(rs.getObject(i + 1));
         }
     }
}