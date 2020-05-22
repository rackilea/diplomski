PreparedStatement ps = con.prepareStatement("select fingerscan from 
datatable where empID like '123'");            
ResultSet rs = ps.executeQuery();
while(rs.next()){
   String tmp = rs.getBytes(1);
   ISOTemplate = tmp.getBytes();
}