PreparedStatement ps = conn.prepareStatement( "select * from login_db where emp_num=? AND pword=?");
ps.setString(1, aes1);
ps.setString(2, aes2); 
ResultSet rs = ps.executeQuery();
if ( rs.next() ){
    //logic here
}