String query = "select logintime from auditlog";  
pst = (PreparedStatement) connection.prepareStatement(query);  
ResultSet rs = pst.executeQuery();

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
java.util.Date fistDate = sdf.parse("2013-02-18 17:11:19");   

while (rs.next()) {  
   String logtime = rs.getString("logintime");  
   java.util.Date parsedDate = sdf.parse(logtime);   

   if(parsedDate.before(fistDate)){   
     continue;   
   }  
   System.out.println(rs.getString("logintime"));  
}