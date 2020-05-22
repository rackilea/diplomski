public void executeMyQuery( Connection con, Integer id) {
String query = "SELECT *FROM STUDENT WHERE 1=1";
if(id != null){
   query += "AND ID = ?";
}
PreparedStatement ps = con.prepareStatement(query);

if(id != null){
   ps.setInt(1, id);
}
ps.executeQuery();}