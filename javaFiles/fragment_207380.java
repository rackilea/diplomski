PreparedStatement pstm = null;
String sql = "select * from owner";
pstm = con.prepareStatement(sql);
ResultSet rs = pstm.executeQuery();
ResultSet firstrs=rs;
String tname="";
while(rs.next())//You have to write resultset like this because if result set is empty then it will gaves an error
{
    tname=rs.getString("tablename");
    tname+=",";
}
if(!tname.equal(""))
{
    String sql1="SELECT * FROM "+tname;///It select multiple tables results
    Statement stmt=con.createStatement();
    ResultSet rs1=stmt.executeQuery(sql1);
    ResultSetMetaData rsmd=rs1.getMetaData();
}