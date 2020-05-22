connection = getConnection();
String sql = "insert into table1 (col1,Rcol2) values (?, ?)";
ps = connection.prepareStatement(sql, new String[] {"colKEY"});
ps.setString(1, col1Val);
ps.setString(2, col2Val);
ps.executeUpdate();     

rs = ps.getGeneratedKeys();
if (rs.next()){
    colKey = new Integer(rs.getInt(1));
}
connection.commit();