if(rs.next())
 {
   userIDD = rs.getInt(1);
   user_fname = rs.getString(2);
   user_lname = rs.getString(3);
   dept_id = rs.getInt(4);
   user_email = rs.getString(5);
   user_password = rs.getString(6);
   user_username = rs.getString(7);
 }