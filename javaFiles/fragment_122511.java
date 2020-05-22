String sql ="select * from Deductions where emp_id = '"+value1+"'";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    if(rs.next()) {              // here
      String val = rs.getString(5);
      String reason = rs.getString(6);
    }