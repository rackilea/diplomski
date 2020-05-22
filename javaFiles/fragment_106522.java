Connection conn=getConnection();
PreparedStatement pst=conn.prepareStatement("select * from user_dtls where USERNAME =? and PASS=?");
pst.setString(username,1);
pst.setString(passwrd,2);
rs=pst.executeQuery();
if(rs.next()){
// HE is valid user
}else{
// INVALID
}