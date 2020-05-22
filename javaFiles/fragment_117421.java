//JAVA                            //PL/SQL
 PreparedStatement ps = con.prepareStatement(
            "select * from role where role_name = ?");
 ps.setString(1, "APPROVER");
 ResultSet rs = ps.executeQuery(); //OPENS the cursor
 while(rs.next()) {                //FETCHES next row from cursor
    //Handle resultset
 }
 rs.close();                       //CLOSES the cursor